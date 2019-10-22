
package pe.com.synopsis.imgrabber.dao.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import java.sql.Types;
import pe.com.synopsis.imgrabber.support.Constants;

@Component
public class SPManagerOfficer extends CPStoredProcedure
{

    private static final String SP_NAME = "P_MGR_OFFICER";
    
    // SP PARAM NAMES
    public static final String OUT_STATUS = "salStatus";
    public static final String IN_NAME = "pName";
    public static final String IN_APEPAT = "pApePat";
    public static final String IN_APEMAT = "pApeMat";
    public static final String IN_MOBILE = "pMobile";
    public static final String IN_PHONE = "pPhone";
    public static final String IN_EMAIL = "pEmail";
    public static final String IN_IDOFFICER = "pIdOfficer";

    @Autowired
    public SPManagerOfficer(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
        .useInParameterNames(IN_NAME, IN_APEPAT, IN_APEMAT, 
                IN_MOBILE, IN_PHONE, IN_EMAIL, IN_IDOFFICER)
        .declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                new SqlParameter(IN_NAME, Types.VARCHAR),
                new SqlParameter(IN_APEPAT, Types.VARCHAR),
                new SqlParameter(IN_APEMAT, Types.VARCHAR),
                new SqlParameter(IN_MOBILE, Types.VARCHAR),
                new SqlParameter(IN_PHONE, Types.VARCHAR),
                new SqlParameter(IN_EMAIL, Types.VARCHAR),
                new SqlParameter(IN_IDOFFICER, Types.BIGINT));
    }

}
