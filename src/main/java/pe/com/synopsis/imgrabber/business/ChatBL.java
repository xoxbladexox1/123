
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import javax.validation.Valid;

import pe.com.synopsis.imgrabber.beans.dto.ContactDTO;
import pe.com.synopsis.imgrabber.beans.dto.MessageDTO;
import pe.com.synopsis.imgrabber.beans.dto.PageDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadContactRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadMessagesRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadPagesRequest;

public interface ChatBL
{
    public List<ContactDTO> loadContact(LoadContactRequest login);

    public List<MessageDTO> loadMessages(@Valid LoadMessagesRequest request);

    public List<PageDTO> loadPages(@Valid LoadPagesRequest request);

}
