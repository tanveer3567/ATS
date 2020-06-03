package com.rsit.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsit.ats.config.JwtTokenUtil;
import com.rsit.ats.model.SystemMessage;
import com.rsit.ats.model.User;
import com.rsit.ats.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/user")
public class UserController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage register(@RequestBody User user) {
		
		return userService.register(user);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage authenticate(@RequestBody User user) throws Exception {
		
		userService.authenticate(user.getUsername(), user.getPassword());
		final SystemMessage sysMessage = userService.authenticate(user);
		final String token = jwtTokenUtil.generateToken((UserDetails)sysMessage.getResult());
		sysMessage.setResult(token);
		return sysMessage;
	}
}
