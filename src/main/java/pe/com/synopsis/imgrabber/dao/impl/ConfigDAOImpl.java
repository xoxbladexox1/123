package pe.com.synopsis.imgrabber.dao.impl;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.request.UpdateConfigRequest;
import pe.com.synopsis.imgrabber.dao.ConfigDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateConfig;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.impl.ChatServiceImpl;
import pe.com.synopsis.imgrabber.support.Constants;
@Component
public class ConfigDAOImpl  implements ConfigDAO {

	private static final Logger logger = LoggerFactory.getLogger(ConfigDAOImpl.class);
	@Autowired
	private SPUpdateConfig sPUpdateConfig;
	
	@Override
	public void cambiarestado(String estado ,String personfk) {
		
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue(SPUpdateConfig.SP_INES,estado)
				.addValue(SPUpdateConfig.SP_INPER,personfk) ;
	
		Map<String,Object> result = sPUpdateConfig.execute(in) ;
		String status = (String) result.get(SPUpdateConfig.OUT_STATUS) ;
		if(!Constants.RESULT_OK.equals(status)) 
		{
			throw new RulesException(status, Constants.RESULT_FAIL_MSG) ;
		}
		
		
		
	}

}
