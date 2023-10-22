package com.org.alltech.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Appointmentid;
	
	private int patientId ;
	private String patientName;
	private Date bookingDate;
	private String timeSlot;
	private String doctorName;
	private String useremail;
	
	
	public Long getAppointmentid() {
		return Appointmentid;
	}

	public void setAppointmentid(Long appointmentid) {
		Appointmentid = appointmentid;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	
	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Appointment(Long appointmentid, int patientId, String patientName, Date bookingDate, String timeSlot,
			String doctorName, String useremail) {
		super();
		Appointmentid = appointmentid;
		this.patientId = patientId;
		this.patientName = patientName;
		this.bookingDate = bookingDate;
		this.timeSlot = timeSlot;
		this.doctorName = doctorName;
		this.useremail = useremail;
	}

	public Appointment() {
		super();
	}
	
}