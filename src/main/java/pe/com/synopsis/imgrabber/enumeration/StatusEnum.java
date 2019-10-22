package pe.com.synopsis.imgrabber.enumeration;

import pe.com.synopsis.imgrabber.beans.response.Status;

public enum StatusEnum 
{
	NOT_AUTHENTICATED("7777", "Acceso denegado."),
    SUCCESS("0000", "El servicio se ha ejecutado de forma correcta.");
	
	private String code;
	private String message;
	
	private StatusEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Status create() {
		return new Status(this.code, this.message);
	}
	
	public boolean isCode(String code) {
	    return this.code.equals(code);
	}
	
	public StatusEnum find(String code) {
        for(StatusEnum codeEnum : values()) {
            if(codeEnum.isCode(code)) {
                return codeEnum;
            }
        }
        return null;
    }
	
}
