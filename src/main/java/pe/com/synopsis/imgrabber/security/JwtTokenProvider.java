package pe.com.synopsis.imgrabber.security;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;

import pe.com.synopsis.imgrabber.enumeration.PropsEnum;

@Component
public class JwtTokenProvider {

	private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    private Environment env;

    public String generateToken(Authentication authentication) {

    	SecurityToken userPrincipal = (SecurityToken) authentication;

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + PropsEnum.JWT_EXPIRATION.getLong(env));

        Gson gson = new Gson();
        
        String token = JWT.create()
                .withSubject(gson.toJson(userPrincipal.getUserInfo()))
                .withExpiresAt(expiryDate)
                .sign(Algorithm.HMAC512(PropsEnum.JWT_SECRET.getString(env).getBytes()));
        
        return token;
    }

    public UserInfo getUserFromJWT(String token) {
        String user = JWT.require(Algorithm.HMAC512(PropsEnum.JWT_SECRET.getString(env).getBytes()))
                .build()
                .verify(token)
                .getSubject();
        
        return UserInfo.fromJson(user);
    }

    public boolean validateToken(String authToken)
    {
    	try
    	{
	    	JWT.require(Algorithm.HMAC512(PropsEnum.JWT_SECRET.getString(env).getBytes()))
	        .build()
	        .verify(authToken);
	    	return true;
    	}catch(Exception e) {
    		logger.error(e.getMessage(), e);
    		return false;
    	}
    }
    
}
