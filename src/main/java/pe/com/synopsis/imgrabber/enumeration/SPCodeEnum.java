package pe.com.synopsis.imgrabber.enumeration;

import pe.com.synopsis.imgrabber.beans.response.Status;

public enum SPCodeEnum 
{
    SUCCESS("0000", "Procesado exitosamente."),
	USER_NOT_EXIST("0002", "Usuario no existe."),
    USER_LOCKOUT("0004", "El usuario se encuentra bloqueado."),
    USER_MAX_ATTEMPT("0003", "Usuario ah supera el limite de intentos."),
    ERROR_PROCESS("8888", "Error en el proceso."),
	LOGIN_ATTEMPT("0001", "Intento fallido de login.");
	
	private String code;
	private String message;
	
	private SPCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Status create() {
		return new Status(this.code, this.message);
	}
	
	public boolean isCode(String code) {
	    return this.code.equals(code);
	}
	
	public String getMessage() {
        return message;
    }
	
	public SPCodeEnum find(String code) {
	    for(SPCodeEnum codeEnum : values()) {
	        if(codeEnum.isCode(code)) {
	            return codeEnum;
	        }
	    }
	    return null;
	}
	
}
