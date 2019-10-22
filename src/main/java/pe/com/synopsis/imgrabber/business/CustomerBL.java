
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.CustomerDTO;
import pe.com.synopsis.imgrabber.beans.request.DelCustomerRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadCustByOfficerRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadCustomerRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateCustomerRequest;

public interface CustomerBL
{
    public List<CustomerDTO> loadCustomer(LoadCustomerRequest login);
    public List<CustomerDTO> loadCustomerByOfficer(LoadCustByOfficerRequest login);
    public void regCustomer(UpdateCustomerRequest request);
    public void updateCustomer(UpdateCustomerRequest request);
    public void delCustomer(DelCustomerRequest request);
}
