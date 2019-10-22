
package pe.com.synopsis.imgrabber.service;

import pe.com.synopsis.imgrabber.beans.request.ResourceRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ResourceService
{
    public Response<byte[]> loadVideo(ResourceRequest request);
    public Response<byte[]> loadResource(ResourceRequest request);
    public Response<byte[]> loadCdnWhatsapp(String resource);
    public Response<byte[]> loadDownload(ResourceRequest request);
}
