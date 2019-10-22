package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;




public class DelExcluidRequest  implements Serializable{
	 private static final long serialVersionUID = 1L;
	 @ApiModelProperty(notes = "id del usuario a eliminar")
	 private String id;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	 
	 
}
