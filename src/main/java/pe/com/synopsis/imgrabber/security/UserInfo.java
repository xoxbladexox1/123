package pe.com.synopsis.imgrabber.security;

import java.beans.Transient;
import java.io.Serializable;

import com.google.gson.Gson;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = -4943465268794839517L;

	private final String username;
    private final String password;
    
    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public UserInfo(final UserInfo userInfo) {
        this.username = userInfo.getUsername();
        this.password = userInfo.getPassword();
    }
	
	public static UserInfo fromJson(String json) {
		Gson gson = new Gson();
		UserInfo userInfo = gson.fromJson(json, UserInfo.class);	
		return userInfo;
	}

	public String getUsername() {
		return username;
	}

	@Transient
	public String getPassword() {
		return password;
	}

}
