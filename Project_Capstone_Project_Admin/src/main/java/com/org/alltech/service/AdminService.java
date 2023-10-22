package com.org.alltech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.alltech.entity.Admin;
import com.org.alltech.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository userRepository;
	
	public Admin registerUser(Admin user) {
		return userRepository.save(user);
	}
	
	public Admin authenticateUser(String username, String password) {
	    List<Admin> users = userRepository.findByUsername(username);
	    
	    for (Admin user : users) {
	        if (user.getPassword().equals(password)) {
	            return user;
	        }
	    }
	    
	    return null;
	}
}
