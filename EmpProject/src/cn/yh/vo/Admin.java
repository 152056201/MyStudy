package cn.yh.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Admin implements Serializable {
	private String id;
	private String password;
	public Admin(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public Admin() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
