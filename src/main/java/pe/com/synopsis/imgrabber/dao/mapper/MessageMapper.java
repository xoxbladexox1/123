
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.FileDownload;
import pe.com.synopsis.imgrabber.beans.domain.Message;

public class MessageMapper implements RowMapper<Message>
{
    private String pathCdn;

    public MessageMapper(String patCdn)
    {
        super();
        this.pathCdn = patCdn;
    }

    // iduser, username, password, secret
    private static final String COLUMN_IDMESSAGE = "MESSAGE_PK";
    private static final String COLUMN_MSGTEXT = "MSGTEXT";
    private static final String COLUMN_MSGDATE = "MSGDATE";
    private static final String COLUMN_MSGHOUR = "MSGHOUR";
    private static final String COLUMN_TOUSER = "TOUSER";
    private static final String COLUMN_TOALIAS = "TOALIAS";
    private static final String COLUMN_AUDIO = "AUDIO";
    private static final String COLUMN_IMAGE = "MSGIMG";
    private static final String COLUMN_HASHMSG = "MSGHASH";
    private static final String COLUMN_MODEMSG = "MSGMODE";
    private static final String COLUMN_HASVIDEO = "HASVIDEO";
    private static final String COLUMN_HASDOWNLOAD = "HASDOWNLOAD";
    
    // Atributos download
    private static final String COLUMN_FILE_NAME = "FNAME";
    private static final String COLUMN_FILE_EXT = "FEXTENSION";
    private static final String COLUMN_FILE_SIZE = "FSIZE";
    private static final String COLUMN_FILE_KEY = "FKEY";
    
    private static final String REGEX_IMG = "(src=\\\")\\/img(\\/[\\w\\d_-]*.png)\"";

    private String convertPathAssets(String msgText)
    {
        if (msgText != null && msgText.contains("crossorigin"))
        {
            return msgText.replaceAll(REGEX_IMG, "$1".concat(pathCdn).concat("$2?[TOKEN]\"") );
        }
        else
        {
            return msgText;
        }
    }

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Message scan = new Message();
        scan.setIdMessage(rs.getString(COLUMN_IDMESSAGE));
        scan.setMsgText(convertPathAssets(rs.getString(COLUMN_MSGTEXT)));
        scan.setMsgDate(rs.getString(COLUMN_MSGDATE));
        scan.setMsgHour(rs.getString(COLUMN_MSGHOUR));
        scan.setToUser(rs.getString(COLUMN_TOUSER));
        scan.setToAlias(rs.getString(COLUMN_TOALIAS));
        scan.setAudio(rs.getBytes(COLUMN_AUDIO));
        scan.setImage(rs.getBytes(COLUMN_IMAGE));
        scan.setHashMsg(rs.getString(COLUMN_HASHMSG));
        scan.setModeMsg(rs.getString(COLUMN_MODEMSG));
        scan.setHasVideo("TRUE".equals(rs.getString(COLUMN_HASVIDEO)));
        
        if(StringUtils.isNotBlank(rs.getString(COLUMN_FILE_KEY)))
        {
            FileDownload fileDownload = new FileDownload();
            fileDownload.setExtension(rs.getString(COLUMN_FILE_EXT));
            fileDownload.setKey(rs.getString(COLUMN_FILE_KEY));
            fileDownload.setName(rs.getString(COLUMN_FILE_NAME));
            fileDownload.setSize(rs.getString(COLUMN_FILE_SIZE));
            fileDownload.setHasDownload("TRUE".equals(rs.getString(COLUMN_HASDOWNLOAD)));
            scan.setFileDownload(fileDownload);
        }
        
        return scan;
    }

}
