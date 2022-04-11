package com.wipro.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

public class StudentController {
public static final String STUDENT_SERVICE="studenService";
@Autowired
private RestTemplate restTemplate;
@GetMapping("/student")
@CircuitBreaker(name=STUDENT_SERVICE,fallbackMethod="studFallback")
public String getStudent() {
	String response=restTemplate.getForObject("http://localhost:5051/students/{id}", String.class);
	return response;
}
@GetMapping("/studentgpa")
@CircuitBreaker(name=STUDENT_SERVICE,fallbackMethod="studFallback")
public String gpaStudent() {
	String response=restTemplate.getForObject("http://localhost:5051/studentgpa", String.class);
	return response;
}
@PutMapping("/updatestudent")
@CircuitBreaker(name=STUDENT_SERVICE,fallbackMethod="studFallback")
public String editStudent() {
	String response=restTemplate.getForObject("http://localhost:5051/updatestudent", String.class);
	return response;
}
@PostMapping("/addstudent")
@CircuitBreaker(name=STUDENT_SERVICE,fallbackMethod="studFallback")
public String addStudent() {
	String response=restTemplate.getForObject("http://localhost:5051/addstudent", String.class);
	return response;
}
@DeleteMapping("/deletestudent")
@CircuitBreaker(name=STUDENT_SERVICE,fallbackMethod="studFallback")
public String deleteStudent() {
	String response=restTemplate.getForObject("http://localhost:5051/deletestudent/{id}", String.class);
	return response;
}
public String studFallback(Exception e) {
	return "Service is down come again later";
}
}
