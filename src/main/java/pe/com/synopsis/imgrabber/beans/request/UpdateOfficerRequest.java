
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class UpdateOfficerRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String name;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String apePat;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String apeMat;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String mobile;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String phone;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String email;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String idOfficer;

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

    public String getIdOfficer()
    {
        return idOfficer;
    }

    public void setIdOfficer(String idOfficer)
    {
        this.idOfficer = idOfficer;
    }

}
