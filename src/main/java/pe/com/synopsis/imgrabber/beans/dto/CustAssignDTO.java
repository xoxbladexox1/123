
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.CustAssign;

@JsonInclude(Include.NON_NULL)
public class CustAssignDTO
{
    private String idCustomer;
    private String name;
    private String apePat;
    private String apeMat;
    private String mobile;
    private String phone;
    private String email;
    private String state;

    public CustAssignDTO()
    {
    }

    public CustAssignDTO(CustAssign source)
    {
        BeanUtils.copyProperties(source, this);
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

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

}
