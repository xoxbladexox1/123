
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class LoadMessagesRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String idChat;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String page;

    public String getIdChat()
    {
        return idChat;
    }

    public void setIdChat(String chatId)
    {
        this.idChat = chatId;
    }

    public String getPage()
    {
        return page;
    }

    public void setPage(String page)
    {
        this.page = page;
    }

}
