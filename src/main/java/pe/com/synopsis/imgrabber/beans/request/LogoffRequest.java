package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


public class LogoffRequest implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @ApiModelProperty(notes = "Id de session")
    private String sessionId;
    
    @NotNull
    @ApiModelProperty(notes = "variable que indica de donde llega la petici&oacute;n")
    private String environment;

    public String getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

	public String getEnvironment() 
	{
		return environment;
	}

	public void setEnvironment(String environment) 
	{
		this.environment = environment;
	}
    
    
}
