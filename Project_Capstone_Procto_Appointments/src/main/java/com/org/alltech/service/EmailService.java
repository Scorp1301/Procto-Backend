package com.org.alltech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.org.alltech.entity.Appointment;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendConfirmationEmail(String userEmail, Appointment appointment) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(userEmail);
        mail.setSubject("Appointment Confirmation");
        mail.setText("Your appointment with " + appointment.getDoctorName() + " on " + appointment.getBookingDate() + " is confirmed. Thank you!");

        javaMailSender.send(mail);
    }
}