
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.Contact;

public class ContactMapper implements RowMapper<Contact>
{
    // iduser, username, password, secret
    private static final String COLUMN_IDCHAT = "CHAT_PK";
    private static final String COLUMN_CHATNAME = "CHATNAME";
    private static final String COLUMN_CHATMOBILE = "CHATMOBILE";
    private static final String COLUMN_LASTUPDATE = "LASTUPDATE";
    private static final String COLUMN_RESOURCE = "RESO_FK";

    private String convertPathAssets(String msgText) {
        if (msgText != null)
        {
            return msgText.replaceAll("(.*)/img/(.*)alt=\".*\"(.*)", "$1https://web.whatsapp.com/img/$2$3");
        }
        else
        {
            return msgText;
        }
    }
    
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Contact contact = new Contact();
        contact.setIdChat(rs.getString(COLUMN_IDCHAT));
        contact.setName(convertPathAssets(rs.getString(COLUMN_CHATNAME)));
        contact.setMobile(rs.getString(COLUMN_CHATMOBILE));
        contact.setLastUpdate(rs.getString(COLUMN_LASTUPDATE));
        contact.setResourceId(rs.getString(COLUMN_RESOURCE));
        return contact;
    }

}
