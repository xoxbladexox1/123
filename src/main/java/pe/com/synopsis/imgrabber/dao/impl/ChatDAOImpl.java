
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Contact;
import pe.com.synopsis.imgrabber.beans.domain.Message;
import pe.com.synopsis.imgrabber.beans.domain.Page;
import pe.com.synopsis.imgrabber.dao.ChatDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadContacts;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadMessages;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadPages;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.support.Constants;
import pe.com.synopsis.imgrabber.support.MessageInventory;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class ChatDAOImpl implements ChatDAO
{
    private static final Logger logger = LoggerFactory.getLogger(ChatDAOImpl.class);

    @Autowired
    SPLoadContacts spLoadContacts;

    @Autowired
    SPLoadMessages spLoadMessages;
    
    @Autowired
    SPLoadPages spLoadPages;
    
    @Autowired
    MessageInventory messageInventory;

    @Override
    public List<Contact> loadContact(String idOfficer)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPLoadContacts.IN_OFFIID, idOfficer);

        Map<String, Object> result = spLoadContacts.execute(in);

        List<Contact> messages = (List<Contact>) result.get(SPLoadContacts.OUT_CURSOR);
        String status = (String) result.get(SPLoadContacts.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }

        return messages;
    }

    @Override
    public List<Message> loadMessages(String chatId, String page)
    {
    	
    	/*----------------------------*/
    	
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPLoadMessages.IN_CHATID, chatId)
                .addValue(SPLoadMessages.IN_PAGE, page);

        
        
        try {
        	Map<String, Object> result = spLoadMessages.execute(in);
			
		} catch (Exception e) {
			logger.error("error al ejecutar el excecute",e.getMessage());
			 logger.error(e.getMessage(), e);
			 logger.error("esta linea esta siendo mostrada desde chatDAO");
		}
        Map<String, Object> result = spLoadMessages.execute(in);
        
        
        

        List<Message> messages = (List<Message>) result.get(SPLoadContacts.OUT_CURSOR);
       
        String status = (String) result.get(SPLoadContacts.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }

        return messages;
        
        /*-------------------------------------*/
        
    }
    
    @Override
    public List<Page> loadPages(String chatId)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPLoadPages.IN_CHATID, chatId);

        Map<String, Object> result = spLoadPages.execute(in);

        List<Page> messages = (List<Page>) result.get(SPLoadContacts.OUT_CURSOR);
        String status = (String) result.get(SPLoadContacts.OUT_STATUS);

        if (!Constants.RESULT_OK.equals(status))
        {
            throw new RulesException(status, Constants.RESULT_FAIL_MSG);
        }

        return messages;
    }

}
