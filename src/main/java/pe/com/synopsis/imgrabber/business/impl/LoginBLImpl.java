
package pe.com.synopsis.imgrabber.business.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.request.LogoffRequest;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.LoginBL;
import pe.com.synopsis.imgrabber.enumeration.PropsEnum;
import pe.com.synopsis.imgrabber.exception.LoginAttemptException;
import pe.com.synopsis.imgrabber.security.JwtTokenProvider;
import pe.com.synopsis.imgrabber.security.SecurityRequest;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.support.Constants;

@Component
public class LoginBLImpl implements LoginBL
{

    private static final Logger logger = LoggerFactory.getLogger(LoginBLImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private Environment env;

    @Override
    public Response<LoginResponse> login(LoginRequest login) throws Exception
    {
        Response<LoginResponse> response = new Response<LoginResponse>();
        try
        {
	        SecurityToken authentication = (SecurityToken) authenticationManager.authenticate(
	                new SecurityRequest(
	                		login.getUsercode(),
	                		login.getPassword(),
	                		login
	                )
	        );
	    	SecurityContextHolder.getContext().setAuthentication(authentication);
            LoginResponse lr = new LoginResponse();
            String jwt = tokenProvider.generateToken(authentication);
            lr.setSessionId(String.format("%s %s", PropsEnum.JWT_PREFIX.getString(env), jwt));
            response.setData(lr);
            response.setStatus(Constants.STATUS_SUCCESSFULL);
        }
        catch(LoginAttemptException e)
        {
            response.setStatus(e.getStatus());
        }
        
        
        catch(Exception e)
        {
        	logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getMessage(), Constants.RESULT_FAIL_MSG));
        }
        
        return response;
    }
    
	@Override
	public Status logout(LogoffRequest request) {
		return Constants.STATUS_SUCCESSFULL;
    	
	}
}
