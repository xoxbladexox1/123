package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class UpdateExcluidRequest  implements Serializable{
	private static final long serialVersionUID = 1L;

	
	// 3 atributos 
	
	@ApiModelProperty(notes = "Nombre del usuario")
	private String id ;
	@ApiModelProperty(notes = "Nombre del usuario")
	private String cellphone ;
	@ApiModelProperty(notes = "Nombre del usuario")
	private String alias;
	@ApiModelProperty(notes = "Nombre del usuario")
	private String personfk;
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPersonfk() {
		return personfk;
	}
	public void setPersonfk(String personfk) {
		this.personfk = personfk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
