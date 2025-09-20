package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.Model.User;
import com.example.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	public User add(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
}
