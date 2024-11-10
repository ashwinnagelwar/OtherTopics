package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

	@GetMapping("/secured/data")
	public String getPrivateData()
	{
		return "You got private Data after processing by interceptor";
	}
	
	@GetMapping("/public/data")
	public String getPublicData()
	{
		return "You got public data";
	}
}
