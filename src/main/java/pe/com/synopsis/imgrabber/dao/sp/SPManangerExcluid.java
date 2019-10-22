package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.support.Constants;
@Component
public class SPManangerExcluid extends CPStoredProcedure {

	private  static final String SP_NAME="SP_AGREGAREXCEPCION";
	public static final String OUT_STATUS = "salStatus";
	public static final String SP_INID="id";
	public static final String SP_INCELL = "CELLPHONE";
	public static final String SP_INAL = "ALIAS";
	public static final String SP_INPRES = "PERSONFK";
	
	public SPManangerExcluid(JdbcTemplate jdbcTemplate) {
		
		
		super(jdbcTemplate, SP_NAME, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void configSP() {
		// TODO Auto-generated method stub
		getSimpleJdbcCall()
		.useInParameterNames(SP_INID,SP_INCELL,SP_INAL,SP_INPRES)
		.declareParameters(
				new SqlOutParameter(OUT_STATUS ,Types.VARCHAR)
				,new SqlParameter(SP_INID , Types.VARCHAR)
				,new SqlParameter(SP_INCELL,Types.VARCHAR),
				new SqlParameter(SP_INAL,Types.VARCHAR)
				,new SqlParameter(SP_INPRES , Types.VARCHAR));
	}

}
