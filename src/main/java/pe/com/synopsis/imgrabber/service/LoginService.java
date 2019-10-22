package pe.com.synopsis.imgrabber.service;

import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.request.LogoffRequest;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;

public interface LoginService {
	
	public Response<LoginResponse> login(LoginRequest login);
	
	public Status logout(LogoffRequest request);
}
