package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


public class LoginRequest implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @ApiModelProperty(notes = "c&oacute;digo de usuario")
    private String usercode;

    @NotNull
    @ApiModelProperty(notes = "password de usuario")
    private String password;
    
    @ApiModelProperty(notes = "variable que indica la versi&oacute;n de la aplicaci&oacute;n")
    private BigDecimal appVersion;
    
    
    

    public String getUsercode()
    {
        return usercode;
    }

    public void setUsercode(String usercode)
    {
        this.usercode = usercode;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

	public BigDecimal getAppVersion() 
	{
		return appVersion;
	}

	public void setAppVersion(BigDecimal appVersion) 
	{
		this.appVersion = appVersion;
	}
    
	
    
}
