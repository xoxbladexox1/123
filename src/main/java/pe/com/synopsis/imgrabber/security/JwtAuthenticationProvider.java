package pe.com.synopsis.imgrabber.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.ValidateUser;
import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.dao.LoginDAO;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginDAO loginDAO;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		SecurityRequest request = (SecurityRequest) authentication;
		LoginRequest login = request.getRequest();
		String username = login.getUsercode();
		ValidateUser validateUser = loginDAO.login(login.getUsercode(), login.getPassword());
		
		UserInfo userInfo = new UserInfo(validateUser.getUsername(), null);
		return new SecurityToken(username, null, null, userInfo);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
