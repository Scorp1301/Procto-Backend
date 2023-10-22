package com.org.alltech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.alltech.entity.Appointment;
import com.org.alltech.service.AppointmentService;
import com.org.alltech.service.EmailService;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return appointmentService.createAppointment(appointment);
	}
	
	@GetMapping("")
	public List<Appointment>getAllDoctors(){
		return appointmentService.getAllAppointments();
	}
	
	@GetMapping("/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable Integer patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentByID(patientId);
        if (appointments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointments);
    }
	
	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
	}
	
	@PostMapping("/send-confirmation-email")
    public void sendConfirmationEmail(@RequestBody Appointment appointment) {
        emailService.sendConfirmationEmail(appointment.getUseremail(),appointment);
    }
	
	

}
