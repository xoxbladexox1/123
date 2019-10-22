
package pe.com.synopsis.imgrabber.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.request.LogoffRequest;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.LoginBL;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.LoginService;
import pe.com.synopsis.imgrabber.support.Constants;

@Service
public class LoginServiceImpl implements LoginService
{

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    
    @Autowired
    private LoginBL loginBL;

    @Override
    public Response<LoginResponse> login(LoginRequest login)
    {
    	
        Response<LoginResponse> response = new Response<LoginResponse>();
        try
        {
            response = loginBL.login(login);
        }
        catch (RulesException ex)
        {
            logger.error(ex.getMessage(), ex);
            response.setStatus(new Status(ex.getErrorcode(), ex.getMessage()));
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(), ex);
            response.setStatus(Constants.STATUS_FAIL);
        }

        return response;
    }

    @Override
    public Status logout(LogoffRequest request)
    {
        Status response;
        try
        {
            response = loginBL.logout(request);
        }
        catch (RulesException ex)
        {
            logger.error(ex.getMessage());
            response = new Status(ex.getErrorcode(), ex.getMessage());
        }
        return response;
    }

}
