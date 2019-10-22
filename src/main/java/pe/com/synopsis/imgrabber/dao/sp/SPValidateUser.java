
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.support.Constants;

@Component
public class SPValidateUser extends CPStoredProcedure
{

    private static final String SP_NAME = "P_VALIDATE_USER";

    // SP PARAM NAMES
    public static final String IN_USERNAME = "@pUsername";
    public static final String IN_PASSWORD = "@pPassword";
    public static final String IN_MAX_DELAY_ATTEMPT = "@maxDelayAttempt";
    public static final String IN_MAXATTEMPTS = "@maxAttempts";
    public static final String OUT_ATTEMPTS = "@salAttempts";
    public static final String OUT_STATUS = "@salStatus";

    @Autowired
    public SPValidateUser(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_USERNAME, IN_PASSWORD)
            .declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                new SqlOutParameter(OUT_ATTEMPTS, Types.INTEGER),
                new SqlParameter(IN_USERNAME, Types.VARCHAR),
                new SqlParameter(IN_PASSWORD, Types.VARCHAR),
                new SqlParameter(IN_MAXATTEMPTS, Types.INTEGER),
                new SqlParameter(IN_MAX_DELAY_ATTEMPT, Types.INTEGER)
            )
            ;
    }

}
