package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class UpdateConfigRequest implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	@ApiModelProperty(notes = "Telefono del usuario")
	private String estado ;
	 @ApiModelProperty(notes = "Nombre del usuario")
	private  String personfk;
	 
	 
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPersonfk() {
		return personfk;
	}
	public void setPersonfk(String personfk) {
		this.personfk = personfk;
	}
	

}
