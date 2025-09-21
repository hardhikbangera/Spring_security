package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.User;
import com.example.Service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		return service.add(user);
	}
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		
		return service.verify(user);
	}
}
