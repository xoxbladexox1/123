
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.ValidateUser;
import pe.com.synopsis.imgrabber.converter.LoginConverter;
import pe.com.synopsis.imgrabber.dao.LoginDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPValidateUser;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.LoginAttemptException;
import pe.com.synopsis.imgrabber.exception.LoginLockoutException;
import pe.com.synopsis.imgrabber.exception.LoginNotFoundException;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.support.Constants;
import pe.com.synopsis.imgrabber.support.MessageInventory;

@Component
@SuppressWarnings({ "unused" })
public class LoginDAOImpl implements LoginDAO
{
    private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
    
    private static final Integer MAX_ATTEMPTS = 3;
    private static final Integer MAX_MINUTES_ATTEMPT = 5;
    
    @Autowired
    SPValidateUser spValidateUser;

    @Autowired
    LoginConverter converter;

    @Autowired
    MessageInventory messageInventory;

    @Override
    public ValidateUser login(String userName, String password)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPValidateUser.IN_USERNAME, userName)
                .addValue(SPValidateUser.IN_PASSWORD, password)
                .addValue(SPValidateUser.IN_MAXATTEMPTS, MAX_ATTEMPTS)
                .addValue(SPValidateUser.IN_MAX_DELAY_ATTEMPT, MAX_MINUTES_ATTEMPT);

        Map<String, Object> result = spValidateUser.execute(in);
        String status = (String) result.get(SPValidateUser.OUT_STATUS);
        
        ValidateUser validateUser = new ValidateUser();
        validateUser.setUsername( userName );
        validateUser.setAccountNonLocked( true );
        
        if (SPCodeEnum.SUCCESS.isCode(status))
        {
            return validateUser;
        }
        else if (SPCodeEnum.USER_NOT_EXIST.isCode(status))
        {
            throw new LoginNotFoundException(SPCodeEnum.USER_NOT_EXIST, validateUser);
        }
        else if (SPCodeEnum.USER_LOCKOUT.isCode(status))
        {
            validateUser.setAccountNonLocked(false);
            throw new LoginLockoutException(SPCodeEnum.USER_LOCKOUT, validateUser);
        }
        else if (SPCodeEnum.USER_MAX_ATTEMPT.isCode(status))
        {
            validateUser.setAccountNonLocked(false);
            throw new LoginLockoutException(SPCodeEnum.USER_MAX_ATTEMPT, validateUser);
        }
        else if (SPCodeEnum.LOGIN_ATTEMPT.isCode(status))
        {
            Integer attemps = (Integer) result.get(SPValidateUser.OUT_ATTEMPTS);
            throw new LoginAttemptException(SPCodeEnum.LOGIN_ATTEMPT, validateUser);
        }
        else
        {
            throw new LoginNotFoundException(SPCodeEnum.ERROR_PROCESS, null);
        }
        
    }

}
