package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Excluid;
import pe.com.synopsis.imgrabber.beans.dto.ExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.DelExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidRequest;
import pe.com.synopsis.imgrabber.business.ExcluidBL;
import pe.com.synopsis.imgrabber.converter.LoadExcluidConverter;
import pe.com.synopsis.imgrabber.dao.ExcluidDAO;

@Component
public class ExcluidBLImpl implements ExcluidBL{
	private static final Logger logger = LoggerFactory.getLogger(ExcluidBLImpl.class);

	@Autowired
	private LoadExcluidConverter loadExcluidConverter;
	
	@Autowired
	private ExcluidDAO excluidDao;
	
	@Override
	public void registerexcluid(UpdateExcluidRequest updateExcluidRequest) {
		updateExcluidRequest.setId(null);
		excluidDao.registerexcluid(updateExcluidRequest) ;
	
	}

	@Override
	public void updateexcluid(UpdateExcluidRequest updateExcluidRequest) {
		// TODO Auto-generated method stub
		excluidDao.updateexcluid(updateExcluidRequest);
		
	}

	@Override
	public void deleteexcluid(DelExcluidRequest delExcluidRequest) {
		// TODO Auto-generated method stub
		excluidDao.deleteexcluid(delExcluidRequest);
		
	}

	@Override
	public List<ExcluidDTO> mostrarexclusionescontel(LoadExcluidRequest loadExcluidRequest) {
	
		List<Excluid> list=  excluidDao.mostrarexclusionescontel(loadExcluidRequest);
		
		return loadExcluidConverter.convert(list) ;
	}

}
