
package pe.com.synopsis.imgrabber.dao;

public interface ResourceDAO
{
    public byte[] loadVideo(String idMessage);
    public byte[] loadResource(String idResource);
    public byte[] loadDownload(String idResource);
}
