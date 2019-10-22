package pe.com.synopsis.imgrabber.exception;

import pe.com.synopsis.imgrabber.beans.domain.ValidateUser;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;

public class LoginNotFoundException  extends LoginAttemptException{

    private static final long serialVersionUID = 829968504269800186L;
    
    public LoginNotFoundException(SPCodeEnum msg, Throwable t, ValidateUser validateUser) {
        super(msg, t, validateUser);
    }

    public LoginNotFoundException(SPCodeEnum msg, ValidateUser validateUser) {
        super(msg, validateUser);
    }

}
