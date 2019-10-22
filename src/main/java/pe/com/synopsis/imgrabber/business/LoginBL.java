
package pe.com.synopsis.imgrabber.business;

import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.request.LogoffRequest;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;

public interface LoginBL
{
    public Response<LoginResponse> login(LoginRequest login) throws Exception;

    public Status logout(LogoffRequest request);

}
