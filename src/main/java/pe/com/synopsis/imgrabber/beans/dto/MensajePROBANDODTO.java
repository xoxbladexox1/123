package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.MensajePROBANDO;



public class MensajePROBANDODTO {
	
	 private String chatnombre;
	 private String chatmobile;
	 
	 
	 
	 
	 
	public MensajePROBANDODTO() {
		
	}
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
	
	public MensajePROBANDODTO( MensajePROBANDO source) {
		BeanUtils.copyProperties(source, this);
	}
	 

	
}
