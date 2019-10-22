
package pe.com.synopsis.imgrabber.beans.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Customer
{
    private String idCustomer;
    private String name;
    private String apePat;
    private String apeMat;
    private String mobile;
    private String phone;
    private String email;
    private String lastUpdate;
    private String resourceId;

    public Customer()
    {
    }

    public String getIdCustomer()
    {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer)
    {
        this.idCustomer = idCustomer;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getApePat()
    {
        return apePat;
    }

    public void setApePat(String apePat)
    {
        this.apePat = apePat;
    }

    public String getApeMat()
    {
        return apeMat;
    }

    public void setApeMat(String apeMat)
    {
        this.apeMat = apeMat;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }

    public String getResourceId()
    {
        return resourceId;
    }

    public void setResourceId(String resourceId)
    {
        this.resourceId = resourceId;
    }

}
