package com.example.Service;

import com.example.Model.UserPrinciple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Model.User;
import com.example.Repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		User user= repo.findByUsername(username);
		if(user==null) {
			System.out.println("Sorry user not found");
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrinciple(user);
	}

}







