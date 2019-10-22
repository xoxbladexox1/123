
package pe.com.synopsis.imgrabber.beans.domain;

public class Message
{
    // iduser, username, password, secret
    private String idMessage;
    private String msgText;
    private String msgDate;
    private String msgHour;
    private String toUser;
    private String toAlias;
    private byte[] audio;
    private byte[] image;
    private String hashMsg;
    private byte[] file;
    private String modeMsg;
    private boolean hasVideo;
    
    // Atributos para archivos por descarga
    private FileDownload fileDownload;

    public String getIdMessage()
    {
        return idMessage;
    }

    public void setIdMessage(String idMessage)
    {
        this.idMessage = idMessage;
    }

    public String getMsgText()
    {
        return msgText;
    }

    public void setMsgText(String msgText)
    {
        this.msgText = msgText;
    }

    public String getMsgDate()
    {
        return msgDate;
    }

    public void setMsgDate(String msgDate)
    {
        this.msgDate = msgDate;
    }

    public String getMsgHour()
    {
        return msgHour;
    }

    public void setMsgHour(String msgHour)
    {
        this.msgHour = msgHour;
    }

    public String getToUser()
    {
        return toUser;
    }

    public void setToUser(String fromUser)
    {
        this.toUser = fromUser;
    }

    public String getToAlias()
    {
        return toAlias;
    }

    public void setToAlias(String aliasUser)
    {
        this.toAlias = aliasUser;
    }

    public byte[] getAudio()
    {
        return audio;
    }

    public void setAudio(byte[] audio)
    {
        this.audio = audio;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public String getHashMsg()
    {
        return hashMsg;
    }

    public void setHashMsg(String hashMsg)
    {
        this.hashMsg = hashMsg;
    }

    public byte[] getFile()
    {
        return file;
    }

    public void setFile(byte[] file)
    {
        this.file = file;
    }

    public String getModeMsg()
    {
        return modeMsg;
    }

    public void setModeMsg(String modeMsg)
    {
        this.modeMsg = modeMsg;
    }

    public boolean isHasVideo()
    {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo)
    {
        this.hasVideo = hasVideo;
    }

    public FileDownload getFileDownload()
    {
        return fileDownload;
    }

    public void setFileDownload(FileDownload fileDownload)
    {
        this.fileDownload = fileDownload;
    }

}
