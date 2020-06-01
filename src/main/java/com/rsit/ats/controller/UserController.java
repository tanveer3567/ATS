package com.rsit.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsit.ats.model.SystemMessage;
import com.rsit.ats.model.User;
import com.rsit.ats.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage addCredentails(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage getCredentials(@RequestBody User user) {
		
		return userService.validate(user);
	}
}
