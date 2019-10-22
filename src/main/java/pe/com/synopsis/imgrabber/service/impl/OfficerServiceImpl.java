
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.CustAssignDTO;
import pe.com.synopsis.imgrabber.beans.dto.MensajePROBANDODTO;
import pe.com.synopsis.imgrabber.beans.dto.OfficerDTO;
import pe.com.synopsis.imgrabber.beans.request.AssignCustomerRequest;
import pe.com.synopsis.imgrabber.beans.request.DelOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.ListAssignCustRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.NameRequestPROBANDO;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.OfficerBL;
import pe.com.synopsis.imgrabber.converter.LoadMessageConverter;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.OfficerService;
import pe.com.synopsis.imgrabber.support.Constants;

@Service
public class OfficerServiceImpl implements OfficerService
{
    private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    LoadMessageConverter converter;

    @Autowired
    private OfficerBL officerBl;
    
    

    @Override
    public Response<List<OfficerDTO>> loadOfficer(LoadOfficerRequest request)
    {
        Response<List<OfficerDTO>> response = new Response<List<OfficerDTO>>();
        try
        {
            response.setData(officerBl.loadOfficer(request));
            response.setStatus(Constants.STATUS_SUCCESSFULL);
        }
        catch (RulesException e)
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
    
    
    
    
    
    @Override
	public Response<List<MensajePROBANDODTO>> buscarconnombre(NameRequestPROBANDO nameRequestPROBANDO) {
		
    	Response<List<MensajePROBANDODTO>> response = new  Response<List<MensajePROBANDODTO>>();
    	
    	try {
    		response.setData(officerBl.buscarconnombre(nameRequestPROBANDO));
    		 response.setStatus(Constants.STATUS_SUCCESSFULL);
    		 logger.error("saddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
    		 logger.error(nameRequestPROBANDO.getMesajeenviado()+"++++++++++++++++++++++++++++++++++++++++++++");
    		
		} catch (Exception e) {
			
			 logger.error("entro al error entro al error entro al error entro al error entro al error entro al error entro al error ");
			logger.error(e.getMessage(), e);
            response.setStatus(Constants.STATUS_FAIL);
		}
    	return response;
    	
    	
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public Response<String> registerOfficer(UpdateOfficerRequest request)
    {
        Response<String> response = new Response<String>();
        try
        {
            officerBl.regOfficer(request);
            response.setStatus(Constants.STATUS_SUCCESSFULL);
        }
        catch (RulesException e)
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
    
    @Override
    public Response<String> updateOfficer(UpdateOfficerRequest request)
    {
        Response<String> response = new Response<String>();
        try
        {
            officerBl.updateOfficer(request);
            response.setStatus(Constants.STATUS_SUCCESSFULL);
        }
        catch (RulesException e)
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
    
    @Override
    public Response<String> assignCustomer(AssignCustomerRequest request)
    {
        Response<String> response = new Response<String>();
        try
        {
            officerBl.updateAssign(request);
            response.setStatus(Constants.STATUS_SUCCESSFULL);
        }
        catch (RulesException e)
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
    
    @Override
    public Response<List<CustAssignDTO>> listAssignCustomer(ListAssignCustRequest request)
    {
        Response<List<CustAssignDTO>> response = new Response<List<CustAssignDTO>>();
        try
        {
            response.setData(officerBl.listAssignCustomer(request));
            response.setStatus(Constants.STATUS_SUCCESSFULL);
        }
        catch (RulesException e)
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

    @Override
    public Response<String> deleteOfficer(DelOfficerRequest request)
    {
        Response<String> response = new Response<String>();
        try
        {
            officerBl.delOfficer(request);
            response.setStatus(Constants.STATUS_SUCCESSFULL);
        }
        catch (RulesException e)
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
