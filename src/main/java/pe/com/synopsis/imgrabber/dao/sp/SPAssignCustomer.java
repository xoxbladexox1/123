
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.support.Constants;

@Component
public class SPAssignCustomer extends CPStoredProcedure
{

  
	

    public SPAssignCustomer(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
    }


	private static final String SP_NAME = "P_ASIGN_CUSTOMER";

    // SP PARAM NAMES
    public static final String OUT_STATUS = "salStatus";
    public static final String IN_OFFIID = "pIdOfficer";
    public static final String IN_CUSTID = "pIdCustomer";
    public static final String IN_CHATSTATE = "pChatState";

   

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
        .useInParameterNames(IN_OFFIID, IN_CUSTID, IN_CHATSTATE)
        .declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                new SqlParameter(IN_OFFIID, Types.BIGINT),
                new SqlParameter(IN_CUSTID, Types.BIGINT),
                new SqlParameter(IN_CHATSTATE, Types.VARCHAR));
    }

}
