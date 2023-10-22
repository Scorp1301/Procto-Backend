package com.org.alltech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.org.alltech.entity.Appointment;

import com.org.alltech.repository.AppointmentRepo;

@Service
public class AppointmentService {
	@Autowired
    private AppointmentRepo appointmentRepository;
	
	@Autowired
	private EmailService emailService;
	

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    public Appointment createAppointment(Appointment appointment) {
    	
    	Appointment savedAppointment = appointmentRepository.save(appointment);
    	
    	
    		try {
                emailService.sendConfirmationEmail(appointment.getUseremail(), savedAppointment);
            } catch (Exception e) {
            	
                e.printStackTrace();
            }
    	
    	return savedAppointment;
    }
    
    public void deleteAppointment(Long id) {
    	appointmentRepository.deleteById(id);
    }
    
    public List<Appointment> getAppointmentByID(Integer patientId){
    	return  appointmentRepository.findByPatientId(patientId);
    }
    
    public void sendMessage(Appointment appointment) {
  
    	try {
            emailService.sendConfirmationEmail(appointment.getUseremail(),appointment);
        } catch (Exception e) {
        
            e.printStackTrace();
        }
    
    }  

}
