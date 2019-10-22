package pe.com.synopsis.imgrabber.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.synopsis.imgrabber.beans.dto.ExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.DelExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.service.ExcluidService;
import pe.com.synopsis.imgrabber.support.Constants;

@RestController
@RequestMapping("/excluid/v1")
public class ExcluidController {
@Autowired
 private ExcluidService excluidService;

@PostMapping("/register")
public ResponseEntity<Response<String>> registerexcluid(@Valid @RequestBody UpdateExcluidRequest updateExcluidRequest){
	
	Response<String> response = excluidService.registerexcluid(updateExcluidRequest);
	if(Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
	{
		return new  ResponseEntity<Response<String>>(response,HttpStatus.OK) ;
	}
	else
	{
		return new  ResponseEntity<Response<String>>(response,HttpStatus.INTERNAL_SERVER_ERROR) ;
		
	}
	
	
}

@PostMapping("/update")
public ResponseEntity<Response<String>> updateexcluid(@Valid @RequestBody UpdateExcluidRequest updateExcluidRequest ){
	Response<String> response = excluidService.updateexcluid(updateExcluidRequest);
	if(!Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
	{
		return new  ResponseEntity<Response<String>>(response,HttpStatus.OK) ;
	}
	else
	{
		return new  ResponseEntity<Response<String>>(response,HttpStatus.INTERNAL_SERVER_ERROR) ;
		
	}
	
	
}


@PostMapping("/delete")
public ResponseEntity<Response<String>> deleteexcluid(@Valid @RequestBody DelExcluidRequest delExcluidRequest)
{
	Response<String> response = excluidService.deleteexcluid(delExcluidRequest);
	if(!Constants.STATUS_SUCCESSFULL.equals(response.getStatus()))
	{
		return new  ResponseEntity<Response<String>>(response,HttpStatus.OK) ;
		
	}
	else
	{
		return new  ResponseEntity<Response<String>>(response,HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	
	
	
}
@PostMapping("/list/excluid")
public ResponseEntity<Response<List<ExcluidDTO>>> mostrarexcluidosconid(@Valid @RequestBody LoadExcluidRequest loadExcluidRequest ){
	
	Response<List<ExcluidDTO>> response = excluidService.mostrarexclusionescontel(loadExcluidRequest);
	if(Constants.STATUS_SUCCESSFULL.equals(response.getStatus())) {
		
		return new ResponseEntity<Response<List<ExcluidDTO>>>(response,HttpStatus.OK) ;
	}
	else {
		return new ResponseEntity<Response<List<ExcluidDTO>>>(response,HttpStatus.INTERNAL_SERVER_ERROR) ;
		
	}
	

}
	
	
}
