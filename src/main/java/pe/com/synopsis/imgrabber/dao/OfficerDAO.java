
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.CustAssign;
import pe.com.synopsis.imgrabber.beans.domain.MensajePROBANDO;
import pe.com.synopsis.imgrabber.beans.domain.Officer;
import pe.com.synopsis.imgrabber.beans.request.NameRequestPROBANDO;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerRequest;

public interface OfficerDAO
{
    public List<Officer> loadOfficer(String userPhone, String userName);
    void mgrOfficer(UpdateOfficerRequest request);
    public List<CustAssign> listAssign(String idOfficer);
    public void updateAssign(String idCustomer, String idOfficer, String state);
    public void deleteOfficer(String idCustomer);
    //prueba
    public List<MensajePROBANDO> buscarconnombre(String namestring);
}
