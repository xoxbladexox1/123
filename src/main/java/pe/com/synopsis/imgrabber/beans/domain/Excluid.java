package pe.com.synopsis.imgrabber.beans.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class Excluid {
	
	private String cellphone;
	private String alias;
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
	
	

}
