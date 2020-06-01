package com.rsit.ats.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsit.ats.model.Applicant;
import com.rsit.ats.model.SystemMessage;
import com.rsit.ats.service.ApplicantService;

@RestController
@RequestMapping(value = "/applicant")
public class ApplicantController {

	@Autowired
	private ApplicantService applicatService;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage getApplicantById(@PathVariable(name = "id") String id) {
		
		return applicatService.getApplicantById(id);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage addApplicant(@RequestBody Applicant applicant) {

		return applicatService.addApplicant(applicant);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage addApplicant(@RequestBody Applicant applicant, @PathVariable(name = "id") String id) {

		return applicatService.updateApplicant(applicant, id);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage addApplicant(@PathVariable(name = "id") String id) {

		return applicatService.deleteApplicant(id);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemMessage addApplicant(@RequestBody Map<String, Object> searchMap) {

		return applicatService.searchApplicant(searchMap);
	}
}
