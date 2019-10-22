package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.support.Constants;
@Component
public class SPdeleteExcluid  extends CPStoredProcedure{

	public static final String SP_NAME="P_DEL_EXCLUID";
	//SP PARAM NAMES
	public static final String OUT_CURSOR="salCursor";
	public static final String OUT_STATUS="salStatus";
	public static final String iNID="ID";
	
	public SPdeleteExcluid(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, SP_NAME, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void configSP() {
		getSimpleJdbcCall()
		.useInParameterNames(iNID)
		.declareParameters(new SqlOutParameter(OUT_STATUS,Types.VARCHAR), new SqlParameter(iNID,Types.VARCHAR));
		// TODO Auto-generated method stub
		
	}

}
