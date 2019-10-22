package pe.com.synopsis.imgrabber.enumeration;

import org.springframework.core.env.Environment;

public enum PropsEnum {
	
	JWT_EXPIRATION("ig.jwt.expiration"),
	JWT_SECRET("ig.jwt.secret"),
	JWT_PREFIX("ig.jwt.prefix"),
	JWT_HEADER("ig.jwt.header"),
	DEV_HOME("DEV_HOME");
	
	private String key;
	
	PropsEnum(String key){
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public String getString(Environment env) {
		return env.getProperty(this.getKey());
	}
	
	public String[] getMultiple(Environment env) {
		return env.getProperty(this.getKey()).split(",");
	}
	
	public Integer getInt(Environment env) {
		return Integer.valueOf(env.getProperty(this.getKey()));
	}
	
	public Long getLong(Environment env) {
		return Long.valueOf(env.getProperty(this.getKey()));
	}
}
