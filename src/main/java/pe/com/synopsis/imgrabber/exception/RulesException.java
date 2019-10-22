package pe.com.synopsis.imgrabber.exception;


public class RulesException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String errorCode;
	
	public RulesException(String errorCode, String message)
	{
		super(message);
        this.setErrorcode(errorCode);
	}
	
	public RulesException(String errorCode, String message, Exception ex)
	{
		super(message, ex);
        this.setErrorcode(errorCode);
	}
	
	private void setErrorcode(String errorCode)
    {
        this.errorCode = errorCode;
    }
	
	public String getErrorcode()
    {
        return errorCode;
    }
}
