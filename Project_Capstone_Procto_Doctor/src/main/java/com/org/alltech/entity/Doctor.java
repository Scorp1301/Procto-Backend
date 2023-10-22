package com.org.alltech.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorid;
	
	private String doctorName;
	private String specialization;
	private String city;
	private double ratings;
	private Date availabledate;
	
	public Long getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(Long doctorid) {
		this.doctorid = doctorid;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
public Date getAvailabledate() {
		return availabledate;
	}
	public void setAvailabledate(Date availabledate) {
		this.availabledate = availabledate;
	}

	public Doctor() {
		super();
	}
	public Doctor(Long doctorid, String doctorName, String specialization, String city, double ratings,
			Date availabledate) {
		super();
		this.doctorid = doctorid;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.city = city;
		this.ratings = ratings;
		this.availabledate = availabledate;
	}
	
}


