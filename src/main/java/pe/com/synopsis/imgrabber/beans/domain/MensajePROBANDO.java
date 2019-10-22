package pe.com.synopsis.imgrabber.beans.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MensajePROBANDO {
	 private String chatnombre;
	 private String chatmobile;
	 
	 
	 
	public String getChatnombre() {
		return chatnombre;
	}
	public void setChatnombre(String chatnombre) {
		this.chatnombre = chatnombre;
	}
	public String getChatmobile() {
		return chatmobile;
	}
	public void setChatmobile(String chatmobile) {
		this.chatmobile = chatmobile;
	}
	public MensajePROBANDO() {
		super();
	}
	 

	
	
}
