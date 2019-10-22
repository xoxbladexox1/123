package pe.com.synopsis.imgrabber.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.synopsis.imgrabber.beans.request.UpdateConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.business.impl.ExcluidBLImpl;
import pe.com.synopsis.imgrabber.service.ConfigService;
import pe.com.synopsis.imgrabber.support.Constants;

@RestController

@RequestMapping("/config")
public class ConfigController {
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);	
	
@Autowired
private ConfigService configServic ;
@PostMapping("/update")
	public ResponseEntity<Response<String>> modificar(@Valid @RequestBody UpdateConfigRequest updateConfigRequest) {
		
		Response<String> response  = configServic.cambiarestado(updateConfigRequest);
		
		
		logger.error("-*---*-*-*-*-**-*--*-*-**-*--**--*-*--*-*-*--*-*----*-*-*-*-*-*-*-**--*-*-*-*-*-*-*-*---*");
		logger.error(updateConfigRequest.getEstado());
		logger.error(updateConfigRequest.getPersonfk());
		logger.error(updateConfigRequest.getPersonfk());
		if(Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
		{
			return new  ResponseEntity<Response<String>>(response,HttpStatus.OK) ;
		}
		
		else
		{
			return new  ResponseEntity<Response<String>>(response,HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
	}
	
	

}
