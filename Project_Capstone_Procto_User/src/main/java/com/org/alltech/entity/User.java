package com.org.alltech.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private long userid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	private String email;
	private String city;
	private String description;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date Bdate;
	
	@Column(name ="firstName")
	private String firstName;
	@Column(name ="lastName")
	private String lastName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	
	public Date getBdate() {
		return Bdate;
	}
	public void setBdate(Date bdate) {
		Bdate = bdate;
	}
	public long getUserid() {
		return userid;
	}
	
	public User(long userid, String username, String password, String email, String city, String description,
			Date bdate, String firstName, String lastName) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
		this.description = description;
		this.Bdate = bdate;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	public User() {
		super();
	}
	
	

}
