package pe.com.synopsis.imgrabber.service;

import pe.com.synopsis.imgrabber.beans.request.UpdateConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ConfigService {
	Response<String> cambiarestado(UpdateConfigRequest updateConfigRequest);  

}
