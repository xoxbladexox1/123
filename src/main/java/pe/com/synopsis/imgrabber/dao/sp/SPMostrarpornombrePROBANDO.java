package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.CustAssignMapper;
import pe.com.synopsis.imgrabber.dao.mapper.HelpMapper;
import pe.com.synopsis.imgrabber.support.Constants;
@Component
public class SPMostrarpornombrePROBANDO extends CPStoredProcedure{

	//nombre 
	private static final String NOMBRE="SP_mostrar_conNombre";
	public static final String OUT_CURSOR = "salCursor";
	//parametros 
	public static final String INFINDNAME ="@partenom";
	
	
	
	
	public SPMostrarpornombrePROBANDO(JdbcTemplate jdbcTemplate) {
		 super(jdbcTemplate, NOMBRE, Constants.PKG_WEB_MANAGER, Constants.SCAN_WEB_SCHEMA);
	}

	@Override
	public void configSP() {
		
		getSimpleJdbcCall()
		.useInParameterNames(INFINDNAME)
		.declareParameters
		(new SqlParameter(INFINDNAME ,Types.VARCHAR))
		.returningResultSet(OUT_CURSOR, new HelpMapper());
	}
	

}
