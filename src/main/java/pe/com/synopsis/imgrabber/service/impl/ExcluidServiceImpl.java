package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.ExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.DelExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.ExcluidBL;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.ExcluidService;
import pe.com.synopsis.imgrabber.support.Constants;
@Service
public class ExcluidServiceImpl  implements ExcluidService{

	private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);
	
	@Autowired 
	ExcluidBL excluidbl;
	
	
	@Override
	public Response<String> registerexcluid(UpdateExcluidRequest updateExcluidRequest) {
		// TODO Auto-generated method stub
		
		Response<String> response = new Response<String>() ;
		try {
			
			excluidbl.registerexcluid(updateExcluidRequest);
			response.setStatus(Constants.STATUS_SUCCESSFULL);
			
		}
		
		catch (RulesException e) {
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


	@Override
	public Response<String> updateexcluid(UpdateExcluidRequest updateExcluidRequest) {
		// TODO Auto-generated method stub
		Response<String> response = new Response<String>();
		try {
			excluidbl.updateexcluid(updateExcluidRequest);
			response.setStatus(Constants.STATUS_SUCCESSFULL);
			
		}
			catch (RulesException e) {
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


	@Override
	public Response<String> deleteexcluid(DelExcluidRequest delExcluidRequest) {
		// TODO Auto-generated method stub
		Response<String> response = new Response<String>();
		try {
			excluidbl.deleteexcluid(delExcluidRequest);
			response.setStatus(Constants.STATUS_SUCCESSFULL);
		}
		
		catch (RulesException e) {
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


	@Override
	public Response<List<ExcluidDTO>> mostrarexclusionescontel(LoadExcluidRequest loadExcluidRequest) {
		// TODO Auto-generated method stub
		
		Response<List<ExcluidDTO>> response = new Response<List<ExcluidDTO>>() ;
		try {
			List<ExcluidDTO> list = excluidbl.mostrarexclusionescontel(loadExcluidRequest);
			response.setData(list);
			
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
