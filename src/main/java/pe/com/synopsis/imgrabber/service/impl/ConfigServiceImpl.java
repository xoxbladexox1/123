package pe.com.synopsis.imgrabber.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.request.UpdateConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.ConfigBL;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.ConfigService;
import pe.com.synopsis.imgrabber.support.Constants;
@Service
public class ConfigServiceImpl implements ConfigService {
private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);
@Autowired
private  ConfigBL configBL; 
	@Override
	public Response<String> cambiarestado(UpdateConfigRequest updateConfigRequest) {
		// TODO Auto-generated method stub
		Response<String> response = new Response<String>();
		
		try {
			configBL.cambiarestado(updateConfigRequest);
			response.setStatus(Constants.STATUS_SUCCESSFULL);
			
			
		} catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(Constants.STATUS_FAIL);
        }
		
		return response;
	}

}
