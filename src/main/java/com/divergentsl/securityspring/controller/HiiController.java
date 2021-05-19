package com.divergentsl.securityspring.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiiController {
	
	@RequestMapping("/hii")
	public String hii() {
		return "hii";
		}
	

}
