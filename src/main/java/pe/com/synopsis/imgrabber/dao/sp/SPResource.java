
package pe.com.synopsis.imgrabber.dao.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import java.sql.Types;
import pe.com.synopsis.imgrabber.dao.mapper.ResourceMapper;
import pe.com.synopsis.imgrabber.support.Constants;

@Component
public class SPResource extends CPStoredProcedure
{

    private static final String SP_NAME = "P_RESOURCE";

    // SP PARAM NAMES
    public static final String OUT_CURSOR = "salCursor";
    public static final String OUT_STATUS = "salStatus";
    public static final String IN_RESOURCEID = "pIdResource";
    public static final String IN_MODE = "pMode";
    
    public static final Integer MODE_RESOURCE = 1;
    public static final Integer MODE_DOWNLOAD = 2;

    @Autowired
    public SPResource(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
        .useInParameterNames(IN_RESOURCEID)
        .declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                new SqlParameter(IN_RESOURCEID, Types.BIGINT),
                new SqlParameter(IN_MODE, Types.BIGINT))
        .returningResultSet(OUT_CURSOR, new ResourceMapper());
        
        // CUANDO SE UTILIZA EL RETURNINGRESULTSET se guarda el resulset en un rowmaper
    }

}
