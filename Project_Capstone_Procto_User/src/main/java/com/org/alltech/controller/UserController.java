package com.org.alltech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.alltech.entity.User;
import com.org.alltech.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<User> getAllUSers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<String> create(@RequestBody User user){
		userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Registered");
		
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User updateUser) {
		return userService.updateUser(id, updateUser);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Registered");
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User credentials){
		
		User user = userService.authenticateUser(credentials.getUsername(), credentials.getPassword());
		if(user!= null) {
			return ResponseEntity.ok("User logged in");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
	}
	
	@PostMapping("/getUserId")
    public Long getUserIdByUsername(@RequestBody User username) {
        return userService.getUserIdByUsername(username.getUsername());
    }

}
