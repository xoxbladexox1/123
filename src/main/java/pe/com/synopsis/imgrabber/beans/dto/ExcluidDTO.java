package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;


import pe.com.synopsis.imgrabber.beans.domain.Excluid;

@JsonInclude
public class ExcluidDTO {
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
	public ExcluidDTO() {
		
	}
	public ExcluidDTO(Excluid source) {
		BeanUtils.copyProperties(source, this);
	}
	

}
