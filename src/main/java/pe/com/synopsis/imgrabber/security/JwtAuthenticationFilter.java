package pe.com.synopsis.imgrabber.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import pe.com.synopsis.imgrabber.enumeration.PropsEnum;

public class JwtAuthenticationFilter extends OncePerRequestFilter
{

    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private Environment env;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);

            if (StringUtils.isNotEmpty(jwt) && tokenProvider.validateToken(jwt)) {
            	
            	UserInfo userInfo = tokenProvider.getUserFromJWT(jwt);
                UserDetails userDetails = new SecurityInfo(userInfo);
                
                UsernamePasswordAuthenticationToken authentication = new SecurityToken(userDetails, null, userDetails.getAuthorities(), userInfo);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = "";
        if(HttpMethod.GET.matches(request.getMethod())) {
            bearerToken = request.getParameter(PropsEnum.JWT_HEADER.getString(env));
        }else {
            bearerToken = request.getHeader(PropsEnum.JWT_HEADER.getString(env));
        }
        String prefix = PropsEnum.JWT_PREFIX.getString(env);
        if (StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith(prefix)) {
            return bearerToken.substring(prefix.length()+1, bearerToken.length());
        }
        return null;
    }
}
