
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.Contact;
import pe.com.synopsis.imgrabber.beans.domain.Message;
import pe.com.synopsis.imgrabber.beans.domain.Page;

public interface ChatDAO
{
    public List<Contact> loadContact(String idOfficer);

    public List<Message> loadMessages(String chatId, String page);

    public List<Page> loadPages(String chatId);
}
