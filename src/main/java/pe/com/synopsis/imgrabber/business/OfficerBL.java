
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.CustAssignDTO;
import pe.com.synopsis.imgrabber.beans.dto.MensajePROBANDODTO;
import pe.com.synopsis.imgrabber.beans.dto.OfficerDTO;
import pe.com.synopsis.imgrabber.beans.request.AssignCustomerRequest;
import pe.com.synopsis.imgrabber.beans.request.DelOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.ListAssignCustRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.NameRequestPROBANDO;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerRequest;

public interface OfficerBL
{
    public List<OfficerDTO> loadOfficer(LoadOfficerRequest login);

    public void regOfficer(UpdateOfficerRequest request);

    public void updateOfficer(UpdateOfficerRequest request);
    
    public void updateAssign(AssignCustomerRequest request);
    
    public List<CustAssignDTO> listAssignCustomer(ListAssignCustRequest request);
    
    public void delOfficer(DelOfficerRequest request);
    
     public List<MensajePROBANDODTO> buscarconnombre(NameRequestPROBANDO namerequest);

}
