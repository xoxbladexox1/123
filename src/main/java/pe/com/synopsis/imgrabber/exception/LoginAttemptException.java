package pe.com.synopsis.imgrabber.exception;

import pe.com.synopsis.imgrabber.beans.domain.ValidateUser;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.security.JwtAuthenticationException;

public class LoginAttemptException extends JwtAuthenticationException{

    private static final long serialVersionUID = 6348836920508891072L;
    
    private final ValidateUser validateUser;
    private final Status status;
    
    public LoginAttemptException(SPCodeEnum status, Throwable t, ValidateUser validateUser) {
        super(status.getMessage(), t);
        this.validateUser = validateUser;
        this.status = status.create();
    }

    public LoginAttemptException(SPCodeEnum status, ValidateUser validateUser) {
        super(status.getMessage());
        this.validateUser = validateUser;
        this.status = status.create();
    }
    
    public ValidateUser getValidateUser() {
        return validateUser;
    }
    
    public Status getStatus() {
        return status;
    }

}
