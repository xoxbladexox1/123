
package pe.com.synopsis.imgrabber.business;

import pe.com.synopsis.imgrabber.beans.request.ResourceRequest;

public interface ResourceBL
{
    public byte[] loadVideo(ResourceRequest login);
    public byte[] loadResource(ResourceRequest login);
    public byte[] loadDownload(ResourceRequest request);

}
