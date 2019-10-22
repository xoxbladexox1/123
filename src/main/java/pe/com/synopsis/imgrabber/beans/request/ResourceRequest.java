
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ResourceRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String idMessage;

    public String getIdMessage()
    {
        return idMessage;
    }

    public void setIdMessage(String idMessage)
    {
        this.idMessage = idMessage;
    }

}
