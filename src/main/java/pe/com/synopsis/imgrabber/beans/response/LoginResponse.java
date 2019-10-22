
package pe.com.synopsis.imgrabber.beans.response;

import io.swagger.annotations.ApiModelProperty;

public class LoginResponse
{
    @ApiModelProperty(notes = "Id de sesi&oacute;n del usuario")
    private String sessionId;

    public String getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

}
