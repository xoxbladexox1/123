
package pe.com.synopsis.imgrabber.service;

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
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface OfficerService
{
    public Response<List<OfficerDTO>> loadOfficer(LoadOfficerRequest request);

    Response<String> registerOfficer(UpdateOfficerRequest request);

    Response<String> updateOfficer(UpdateOfficerRequest request);

    Response<String> assignCustomer(AssignCustomerRequest request);

    Response<List<CustAssignDTO>> listAssignCustomer(ListAssignCustRequest request);
    
    Response<String> deleteOfficer(DelOfficerRequest request);
    public Response<List<MensajePROBANDODTO>> buscarconnombre (NameRequestPROBANDO nameRequestPROBANDO);
}
