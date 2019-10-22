package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class LoadExcluidRequest implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 @ApiModelProperty(notes ="telefono del usuario")
	 private String userphone ;
	 
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	 
}
