
package pe.com.synopsis.imgrabber.beans.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import pe.com.synopsis.imgrabber.dao.sp.SPValidateUser;

@JsonRootName(value = "user")
@JsonInclude(Include.NON_NULL)
public class UserDTO
{
    @JsonProperty
    @ApiModelProperty(notes = "Client ID asociado al usuario")
    private String id;
    @JsonProperty
    @ApiModelProperty(notes = "Nombres del usuario")
    private String fullname;
    @JsonProperty
    @ApiModelProperty(notes = "Fecha de nacimiento del usuario")
    private String birthdate;
    @JsonProperty
    @ApiModelProperty(notes = "Tipo de persona del usuario")
    private int type;
    @JsonProperty
    @ApiModelProperty(notes = "Estado de acceso del usuario")
    private int statusAccess;
    @JsonProperty
    @ApiModelProperty(notes = "Imagen asociada al usuario codificada en base 64")
    private String userImage;

    public UserDTO() {
    }
    
    public UserDTO(SPValidateUser source){
        
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public String getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(String birthdate)
    {
        this.birthdate = birthdate;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getStatusAccess()
    {
        return statusAccess;
    }

    public void setStatusAccess(int statusAccess)
    {
        this.statusAccess = statusAccess;
    }

    public String getUserImage()
    {
        return userImage;
    }

    public void setUserImage(String userImage)
    {
        this.userImage = userImage;
    }
}
