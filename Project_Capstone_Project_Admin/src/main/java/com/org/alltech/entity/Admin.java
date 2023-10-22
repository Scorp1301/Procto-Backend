package com.org.alltech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adminid")
	private long adminid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;

	

	public long getAdminid() {
		return adminid;
	}
	public void setAdminid(long adminid) {
		this.adminid = adminid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Admin(long adminid, String username, String password) {
		super();
		this.adminid = adminid;
		this.username = username;
		this.password = password;
	}

	public Admin() {
		super();
	}
	
	

}
