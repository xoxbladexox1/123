package pe.com.synopsis.imgrabber.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityInfo implements UserDetails {

	private static final long serialVersionUID = -4943465268794839517L;
	
	private final UserInfo userInfo;
	
	public SecurityInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.getUserInfo().getPassword();
	}

	@Override
	public String getUsername() {
		return this.getUserInfo().getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

}
