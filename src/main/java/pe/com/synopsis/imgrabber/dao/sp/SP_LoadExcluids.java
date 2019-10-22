package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.ExcluidMapper;
import pe.com.synopsis.imgrabber.support.Constants;
@Component
public class SP_LoadExcluids extends CPStoredProcedure {

	//SPNAME
	public static final String SP_NAME="P_LOADEXCLUID";
	//SP PARAMAS
	 public static final String OUT_CURSOR = "salCursor";
	public static final String OUT_STATUS = "salStatus";
	public static final String SP_INPNA = "pname" ;
	public SP_LoadExcluids(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, SP_NAME,Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void configSP() {
	getSimpleJdbcCall().useInParameterNames(SP_INPNA)
	.declareParameters(
			new SqlOutParameter(OUT_STATUS,Types.VARCHAR),
			new SqlParameter(SP_INPNA, Types.VARCHAR))
	.returningResultSet(OUT_CURSOR, new ExcluidMapper());
		// TODO Auto-generated method stub
		
	}

}
