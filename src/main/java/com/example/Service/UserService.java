package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Model.User;
import com.example.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;
	
	@Autowired
	JWTService service;
	
	@Autowired
	AuthenticationManager manager;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	public User add(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
	public String verify(User user) {
		Authentication auth=manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	
		if(auth.isAuthenticated()) {
			return service.getToken(user.getUsername());
		}else {
		return "failure";
		}
	}
}
