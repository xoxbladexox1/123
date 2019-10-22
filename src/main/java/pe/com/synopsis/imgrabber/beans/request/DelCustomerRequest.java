
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class DelCustomerRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String idCustomer;
    
    public String getIdCustomer()
    {
        return idCustomer;
    }

    public void setIdCustomer(String officerId)
    {
        this.idCustomer = officerId;
    }

}
