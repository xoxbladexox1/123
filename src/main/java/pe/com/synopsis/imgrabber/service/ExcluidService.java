package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.ExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.DelExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ExcluidService {
	
	Response<String> registerexcluid(UpdateExcluidRequest updateExcluidRequest);
	Response<String> updateexcluid(UpdateExcluidRequest updateExcluidRequest);
	Response<String> deleteexcluid(DelExcluidRequest delExcluidRequest);
	Response<List<ExcluidDTO>> mostrarexclusionescontel(LoadExcluidRequest loadExcluidRequest) ;

}
