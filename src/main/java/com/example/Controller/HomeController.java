package com.example.Controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Student;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	List<Student> stu=new ArrayList<>(List.of(
			new Student(1, "hardhik"),
			new Student(2, "Hero")
			));
	
	@GetMapping("/")
	public String Home() {
		return "Home";
	}
	@GetMapping("/public")
	@ResponseBody
	public Object get(HttpServletRequest req) {
		return req.getAttribute("_csrf");
	}

	
	@GetMapping("/student")
	@ResponseBody
	public List<Student> getstudent() {
		return stu;
	}

	
	@PostMapping("/student")
	@ResponseBody
	public List<Student> addstudent(@RequestBody Student student) {
		stu.add(student);
		return stu;
	}
	
}
