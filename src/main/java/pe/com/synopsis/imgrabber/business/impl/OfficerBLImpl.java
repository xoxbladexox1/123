
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.CustAssign;
import pe.com.synopsis.imgrabber.beans.domain.MensajePROBANDO;
import pe.com.synopsis.imgrabber.beans.domain.Officer;
import pe.com.synopsis.imgrabber.beans.dto.CustAssignDTO;
import pe.com.synopsis.imgrabber.beans.dto.MensajePROBANDODTO;
import pe.com.synopsis.imgrabber.beans.dto.OfficerDTO;
import pe.com.synopsis.imgrabber.beans.request.AssignCustomerRequest;
import pe.com.synopsis.imgrabber.beans.request.DelOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.ListAssignCustRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.NameRequestPROBANDO;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerRequest;
import pe.com.synopsis.imgrabber.business.OfficerBL;
import pe.com.synopsis.imgrabber.converter.AssignCustomerConverter;
import pe.com.synopsis.imgrabber.converter.LoadMessagePROBANDO;
import pe.com.synopsis.imgrabber.converter.LoadOfficerConverter;
import pe.com.synopsis.imgrabber.dao.OfficerDAO;

@Component
public class OfficerBLImpl implements OfficerBL
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(OfficerBLImpl.class);

    @Autowired
    private OfficerDAO officerDao;

    @Autowired
    LoadOfficerConverter converter;
    
    
    @Autowired
    LoadMessagePROBANDO loadMessagePROBANDO;
    
    @Autowired
    AssignCustomerConverter assignConverter;

    @Override
    public List<OfficerDTO> loadOfficer(LoadOfficerRequest request)
    {
        List<Officer> msgs =  officerDao.loadOfficer(request.getUserPhone(), request.getUserName());
        
        //convierte de list officer a dto 
        return converter.convert(msgs);
    }
    
    
    
    @Override
	public List<MensajePROBANDODTO> buscarconnombre(NameRequestPROBANDO namerequest) {
    	List<MensajePROBANDO> msgs = officerDao.buscarconnombre(namerequest.getMesajeenviado());
    	
    	
		// TODO Auto-generated method stub
		return loadMessagePROBANDO.convert(msgs);
	}
    
    
    
    
    
    
    @Override
    public void regOfficer(UpdateOfficerRequest request)
    {
        request.setIdOfficer(null);
        officerDao.mgrOfficer(request);
    }
    
    @Override
    public void updateOfficer(UpdateOfficerRequest request)
    {
        officerDao.mgrOfficer(request);
    }

    @Override
    public void updateAssign(AssignCustomerRequest request)
    {
        officerDao.updateAssign(request.getIdCustomer(), request.getIdOfficer(), request.getState());
    }

    @Override
    public List<CustAssignDTO> listAssignCustomer(ListAssignCustRequest request)
    {
        List<CustAssign> result = officerDao.listAssign(request.getIdOfficer());
        return assignConverter.convert(result);
    }

    @Override
    public void delOfficer(DelOfficerRequest request)
    {
        officerDao.deleteOfficer(request.getIdOfficer());
    }

	

}
