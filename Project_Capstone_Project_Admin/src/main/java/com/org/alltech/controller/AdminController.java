package com.org.alltech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.alltech.entity.Admin;
import com.org.alltech.service.AdminService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	private AdminService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Admin user){
		userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Registered");
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Admin credentials){
		
		Admin user = userService.authenticateUser(credentials.getUsername(), credentials.getPassword());
		if(user!= null) {
			return ResponseEntity.ok("User logged in");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
	}

}
