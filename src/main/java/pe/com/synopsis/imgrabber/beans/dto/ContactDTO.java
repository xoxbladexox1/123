
package pe.com.synopsis.imgrabber.beans.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.Contact;

@JsonInclude(Include.NON_NULL)
public class ContactDTO
{
    private String idChat;
    private String name;
    private String mobile;
    private String lastUpdate;
    private String resourceId;
    private List<PageDTO> pages;

    public ContactDTO()
    {
    }

    public ContactDTO(Contact source)
    {
        BeanUtils.copyProperties(source, this, "pages");
        this.setPages(source.getPages().stream().map(PageDTO::new).collect(Collectors.toList()));
    }

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

    public List<PageDTO> getPages()
    {
        return pages;
    }

    public void setPages(List<PageDTO> pages)
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
