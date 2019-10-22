package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.support.Constants;

@Component
public class SPUpdateConfig  extends CPStoredProcedure{
public static final String SP_NAME="P_ALTERCONFIG";

//params

public static final String OUT_STATUS="salStatus";
public static final String  SP_INES="estado";
public static final String  SP_INPER="personfk";
	
	public SPUpdateConfig(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, SP_NAME,  Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void configSP() {
		
		getSimpleJdbcCall()
		.useInParameterNames(SP_INES,SP_INPER)
		.declareParameters(
				new SqlOutParameter(OUT_STATUS,Types.VARCHAR),
				new SqlParameter(SP_INES,Types.VARCHAR),
				new SqlParameter(SP_INPER,Types.VARCHAR));
		// TODO Auto-generated method stub
		
	}

}
