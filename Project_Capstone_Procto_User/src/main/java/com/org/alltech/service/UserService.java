package com.org.alltech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.alltech.entity.User;
import com.org.alltech.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User updateUser(Long id , User updateUser) {
		User existingUser = userRepository.findById(id).orElse(null);
		if(existingUser != null) {
			existingUser.setUsername(updateUser.getUsername());
			existingUser.setPassword(updateUser.getPassword());
			existingUser.setFirstName(updateUser.getFirstName());
			existingUser.setLastName(updateUser.getLastName());
			existingUser.setBdate(updateUser.getBdate());
			existingUser.setEmail(updateUser.getEmail());
			existingUser.setCity(updateUser.getCity());
			existingUser.setDescription(updateUser.getDescription());
			return userRepository.save(existingUser);
		}
		return null;
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User authenticateUser(String username, String password) {
	    List<User> users = userRepository.findByUsername(username);
	    
	    for (User user : users) {
	        if (user.getPassword().equals(password)) {
	            return user;
	        }
	    }
	    
	    return null;
	}
	
	 public Long getUserIdByUsername(String username) {
	        User user = userRepository.findIDByUsername(username);
	        if (user != null) {
	            return user.getUserid();
	        } else {
	            return null; 
	        }
	    }
	
}
