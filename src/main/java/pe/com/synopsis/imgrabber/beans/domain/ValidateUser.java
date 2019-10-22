
package pe.com.synopsis.imgrabber.beans.domain;

public class ValidateUser
{
    // iduser, username, password, secret
    private String iduser;
    private String username;
    private String password;
    private String secret;
    private boolean accountNonLocked;

	public String getIduser()
    {
        return iduser;
    }

    public void setIduser(String iduser)
    {
        this.iduser = iduser;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSecret()
    {
        return secret;
    }

    public void setSecret(String secret)
    {
        this.secret = secret;
    }
   
    public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/*
	public String getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(String credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
*/
	@Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ValidateUserSP [iduser=");
        builder.append(iduser);
        builder.append(", username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", secret=");
        builder.append(secret);
        builder.append("]");
        return builder.toString();
    }

}
