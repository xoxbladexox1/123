
package pe.com.synopsis.imgrabber.dao.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import java.sql.Types;
import pe.com.synopsis.imgrabber.dao.mapper.MessageMapper;
import pe.com.synopsis.imgrabber.support.Constants;

@Component
public class SPLoadMessages extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_MESSAGES";

    @Autowired
    private Environment env;
    
    // SP PARAM NAMES
    public static final String OUT_CURSOR = "salCursor";
    public static final String OUT_STATUS = "salStatus";
    public static final String IN_CHATID = "pIdChat";
    public static final String IN_PAGE = "pPage";

    @Autowired
    public SPLoadMessages(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
    }

    @Override
    public void configSP()
    {
        MessageMapper mapper = new MessageMapper(env.getProperty("PATH_CDN"));
        getSimpleJdbcCall()
        .useInParameterNames(IN_CHATID, IN_PAGE)
        .declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                new SqlParameter(IN_CHATID, Types.BIGINT),
                new SqlParameter(IN_PAGE, Types.VARCHAR))
        .returningResultSet(OUT_CURSOR, mapper);
    }

}
