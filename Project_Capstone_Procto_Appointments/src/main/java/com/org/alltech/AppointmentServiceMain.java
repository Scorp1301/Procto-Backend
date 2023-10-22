package com.org.alltech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class AppointmentServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentServiceMain.class, args);
	}
}
