package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.Excluid;
import pe.com.synopsis.imgrabber.beans.dto.ExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.DelExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidRequest;


public interface ExcluidBL {
	
	public void  registerexcluid(UpdateExcluidRequest updateExcluidRequest);
	public void  updateexcluid(UpdateExcluidRequest updateExcluidRequest);
	public void  deleteexcluid(DelExcluidRequest delExcluidRequest);
	public List<ExcluidDTO> mostrarexclusionescontel(LoadExcluidRequest loadExcluidRequest) ;

}
