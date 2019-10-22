
package pe.com.synopsis.imgrabber.beans.domain;

import java.util.List;

public class Contact
{

    // iduser, username, password, secret
    private String idChat;
    private String name;
    private String mobile;
    private String lastUpdate;
    private String resourceId;
    private List<Page> pages;

    public String getIdChat()
    {
        return idChat;
    }

    public void setIdChat(String idChat)
    {
        this.idChat = idChat;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }

    public List<Page> getPages()
    {
        return pages;
    }

    public void setPages(List<Page> pages)
    {
        this.pages = pages;
    }

    public String getResourceId()
    {
        return resourceId;
    }

    public void setResourceId(String resourceId)
    {
        this.resourceId = resourceId;
    }
}
