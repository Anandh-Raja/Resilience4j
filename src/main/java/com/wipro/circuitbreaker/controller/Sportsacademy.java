package com.wipro.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

public class Sportsacademy {
	public static final String SPORT_SERVICE="studenService";
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/student")
	@CircuitBreaker(name=SPORT_SERVICE,fallbackMethod="sportsFallback")
	public String getSports() {
		String response=restTemplate.getForObject("http://localhost:5052/getsports", String.class);
		return response;
	}

public String sportsFallback(Exception e) {
	return "Service is down come again later";
}
}
