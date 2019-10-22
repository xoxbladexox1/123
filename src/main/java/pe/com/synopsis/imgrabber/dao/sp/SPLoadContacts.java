
package pe.com.synopsis.imgrabber.dao.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import java.sql.Types;
import pe.com.synopsis.imgrabber.dao.mapper.ContactMapper;
import pe.com.synopsis.imgrabber.support.Constants;

@Component
public class SPLoadContacts extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_CONTACTS";

    // SP PARAM NAMES
    public static final String OUT_CURSOR = "salCursor";
    public static final String OUT_STATUS = "salStatus";
    public static final String IN_OFFIID = "pIdOfficer";

    @Autowired
    public SPLoadContacts(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
        .useInParameterNames(IN_OFFIID)
        .declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                new SqlParameter(IN_OFFIID, Types.BIGINT))
        .returningResultSet(OUT_CURSOR, new ContactMapper());
    }

}
