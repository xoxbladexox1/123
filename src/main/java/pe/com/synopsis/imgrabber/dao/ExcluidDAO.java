package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.Excluid;
import pe.com.synopsis.imgrabber.beans.request.DelExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidRequest;


public interface ExcluidDAO {
	
	public void  registerexcluid(UpdateExcluidRequest updateExcluidRequest);
	public void  updateexcluid(UpdateExcluidRequest updateExcluidRequest);
	public void  deleteexcluid(DelExcluidRequest delExcluidRequest);
	public List<Excluid> mostrarexclusionescontel(LoadExcluidRequest loadExcluidRequest);
	public List<Excluid> mostrarexclusiones();

}
