
package pe.com.synopsis.imgrabber.dao.impl;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Resource;
import pe.com.synopsis.imgrabber.dao.ResourceDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPResource;
import pe.com.synopsis.imgrabber.dao.sp.SPVideo;
import pe.com.synopsis.imgrabber.enumeration.PropsEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.support.Constants;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class ResourceDAOImpl implements ResourceDAO
{
    private static final Logger logger = LoggerFactory.getLogger(ResourceDAOImpl.class);

    @Autowired
    private SPVideo spVideo;
    
    @Autowired
    private SPResource spResource;
    
    @Autowired
    private Environment env;

    @Override
    public byte[] loadVideo(String idMessage)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPVideo.IN_MESSAGEID, idMessage);

        Map<String, Object> result = spVideo.execute(in);

        List<Resource> video = (List<Resource>) result.get(SPVideo.OUT_CURSOR);
        String status = (String) result.get(SPVideo.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }

        return video.get(0).getContent();
    }
    
    @Override
    public byte[] loadResource(String idResource)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPResource.IN_RESOURCEID, idResource)
                .addValue(SPResource.IN_MODE, SPResource.MODE_RESOURCE);

        Map<String, Object> result = spResource.execute(in);

        List<Resource> resource = (List<Resource>) result.get(SPResource.OUT_CURSOR);
        String status = (String) result.get(SPResource.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }

        byte[] data = resource.get(0).getContent();
        
        return data;
    }

    @Override
    public byte[] loadDownload(String idResource)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPResource.IN_RESOURCEID, idResource)
                .addValue(SPResource.IN_MODE, SPResource.MODE_DOWNLOAD);

        Map<String, Object> result = spResource.execute(in);

        List<Resource> resource = (List<Resource>) result.get(SPResource.OUT_CURSOR);
        String status = (String) result.get(SPResource.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }


        byte[] data = resource.get(0).getContent();

        String path = PropsEnum.DEV_HOME.getString(env) + "/download.file";
        try(OutputStream os = new FileOutputStream(path);){
            os.write(data);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return data;
    }

}
