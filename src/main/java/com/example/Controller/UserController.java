package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Model.User;
import com.example.Service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/save")
	@ResponseBody
	public User getlist(@RequestBody User user) {
		return service.add(user);
	}
}
