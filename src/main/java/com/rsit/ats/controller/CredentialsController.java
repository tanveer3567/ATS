package com.rsit.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsit.ats.model.Credentails;
import com.rsit.ats.model.SystemMessage;
import com.rsit.ats.service.CredentialsService;

@RestController
@RequestMapping(value = "/credentials")
public class CredentialsController {
	
	@Autowired
	private CredentialsService credentialsService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage addCredentails(@RequestBody Credentails credentials) {
		
		return credentialsService.addCredentials(credentials);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage getCredentials(@PathVariable(name = "id") String id) {
		
		return credentialsService.getCredentials(id);
	}
}
