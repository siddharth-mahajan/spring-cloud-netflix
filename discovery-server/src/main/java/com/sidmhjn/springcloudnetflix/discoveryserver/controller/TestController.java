package com.sidmhjn.springcloudnetflix.discoveryserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${spring.application.name}")
	public String ApplicationName;
		
	@GetMapping("/test")
	public String Test() {
		return "Welcome to " + ApplicationName;
	}
	
}
