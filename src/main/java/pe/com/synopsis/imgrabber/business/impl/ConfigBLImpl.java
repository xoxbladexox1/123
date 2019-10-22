package pe.com.synopsis.imgrabber.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.request.UpdateConfigRequest;
import pe.com.synopsis.imgrabber.business.ConfigBL;
import pe.com.synopsis.imgrabber.dao.ConfigDAO;

@Component
public class ConfigBLImpl  implements ConfigBL{

@Autowired
private ConfigDAO configDAO ;
	
	@Override
	public void cambiarestado(UpdateConfigRequest updateConfigRequest) {
		
		configDAO.cambiarestado(updateConfigRequest.getEstado(),updateConfigRequest.getPersonfk());
		
		// TODO Auto-generated method stub
		
	}
	

}
