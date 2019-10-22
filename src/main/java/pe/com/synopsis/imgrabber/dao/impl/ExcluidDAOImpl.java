package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Excluid;
import pe.com.synopsis.imgrabber.beans.request.DelExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.dao.ExcluidDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPManangerExcluid;
import pe.com.synopsis.imgrabber.dao.sp.SP_LoadExcluids;
import pe.com.synopsis.imgrabber.dao.sp.SPdeleteExcluid;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.impl.ChatServiceImpl;
import pe.com.synopsis.imgrabber.support.Constants;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class ExcluidDAOImpl  implements ExcluidDAO{
	private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);
	
	@Autowired
	private  SP_LoadExcluids sP_LoadExcluids;
	
	@Autowired
	private SPManangerExcluid sPManangerExcluid;
	
	@Autowired 
	 private SPdeleteExcluid sPdeleteExcluid;
	
	@Override
	public void registerexcluid(UpdateExcluidRequest updateExcluidRequest) {
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue(SPManangerExcluid.SP_INID, updateExcluidRequest.getId())
				.addValue(SPManangerExcluid.SP_INCELL,updateExcluidRequest.getCellphone())
				.addValue(SPManangerExcluid.SP_INAL,updateExcluidRequest.getAlias())
				.addValue(SPManangerExcluid.SP_INPRES,updateExcluidRequest.getPersonfk()) ;
		
		Map<String, Object> result = sPManangerExcluid.execute(in) ;
		String status = (String) result.get(SPManangerExcluid.OUT_STATUS);
		
		logger.error("el valor de status es fuera del if---------------------------------------------------------------------------------");
		logger.error(status);
		if(!Constants.RESULT_OK.equals(status)) 
		{
			logger.error("el valor de status es---------------------------------------------------------------------------------");
			logger.error(status);
			throw new RulesException(status, Constants.RESULT_FAIL_MSG) ;
			
		}
		
		 
	}

	@Override
	public void updateexcluid(UpdateExcluidRequest updateExcluidRequest) {
		
		
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue(SPManangerExcluid.SP_INID, updateExcluidRequest.getId())
				.addValue(SPManangerExcluid.SP_INCELL,updateExcluidRequest.getCellphone())
				.addValue(SPManangerExcluid.SP_INAL,updateExcluidRequest.getAlias())
				.addValue(SPManangerExcluid.SP_INPRES,updateExcluidRequest.getPersonfk()) ;
		
		Map<String, Object> result = sPManangerExcluid.execute(in) ;
		String status = (String) result.get(SPManangerExcluid.OUT_STATUS);
		
		logger.error("el valor de status es fuera del if---------------------------------------------------------------------------------");
		logger.error(status);
		if(!Constants.RESULT_OK.equals(status)) 
		{
			logger.error("el valor de status es---------------------------------------------------------------------------------");
			logger.error(status);
			throw new RulesException(status, Constants.RESULT_FAIL_MSG) ;
			
		}
		
		
	}

	@Override
	public void deleteexcluid(DelExcluidRequest delExcluidRequest) {
		// TODO Auto-generated method stub
		SqlParameterSource in = new MapSqlParameterSource().addValue(SPdeleteExcluid.iNID, delExcluidRequest.getId());
		Map<String, Object> result = sPdeleteExcluid.execute(in);
		String status = (String) result.get(SPdeleteExcluid.OUT_STATUS);
		
		 if (!Constants.RESULT_OK.equals(status))
	        {
	            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
	        }
		
	}

	@Override
	public List<Excluid> mostrarexclusionescontel(LoadExcluidRequest loadExcluidRequest) {
		// devuelve los numeros bloqueados de un usuario en especifico
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue(SP_LoadExcluids.SP_INPNA, loadExcluidRequest.getUserphone());
		
		Map<String, Object> result = sP_LoadExcluids.execute(in);
		String status = (String) result.get(SP_LoadExcluids.OUT_STATUS) ;
		if(!Constants.RESULT_OK.equals(status))
		{
			 throw new RulesException(status, Constants.RESULT_FAIL_MSG);
		}
		List<Excluid> list = (List<Excluid>) result.get(SP_LoadExcluids.OUT_CURSOR) ;
		return list;
		
		
		
		
	}

	@Override
	public List<Excluid> mostrarexclusiones() {
		// devuelve todos los numeros bloqueados sin escepecion
		return null;
	}

}
