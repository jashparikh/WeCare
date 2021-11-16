package com.springboot.wecare.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.wecare.model.Appointment;
import com.springboot.wecare.model.Caregiver;
import com.springboot.wecare.model.Login;
import com.springboot.wecare.model.Query;
import com.springboot.wecare.service.IAppointmentService;
import com.springboot.wecare.service.ICaregiverService;
import com.springboot.wecare.service.IClientService;
import com.springboot.wecare.service.ILoginService;
import com.springboot.wecare.service.IqueryService;


@RestController
public class CaregiverController {
    
	@Autowired
	IAppointmentService appointmentService;
	
	@Autowired
	ICaregiverService caregiverService;
	
	@Autowired
	ILoginService loginService;
	
	@Autowired 
	IClientService clientService;
	
	@Autowired
	IqueryService queryService;

	@GetMapping("/ViewProfileInfo")
	public List<Caregiver> getAllCaregivers() {
		System.out.println("Get all data..");

		return caregiverService.getAll();
	}
		
	@GetMapping("/CaregiverInfo")
	public String CaregiverInfo(@RequestParam @Valid long caregiverid) {
		System.out.println("Get specific caregiver");

		return caregiverService.caregiverInfo(caregiverid);
	}
	

	@CrossOrigin
	@PostMapping("/addCaregiver")
	public String addCaregiver(@RequestBody @Valid Caregiver caregiver) {
		String contact = caregiverService.addCaregiver(caregiver);

		return contact;
	}

	@CrossOrigin
	@PutMapping("/UpdateProfileInfo")
	public String UpdateCaregiver(@RequestBody @Valid Caregiver caregiver) {
		String response = caregiverService.updateCaregiver(caregiver);

		return response;
	}
	
	
	@CrossOrigin
	@DeleteMapping("/deleteCaregiver")
	public String deleteCaregiver(@RequestParam @Valid long caregiverid) {
		String response = caregiverService.deleteCaregiver(caregiverid);

		return response;
	}
	
	
	
	

	@GetMapping("/allQueries")
	public List<Query> getAllQueries() {
		System.out.println("Get all data..");

		return queryService.getAll();
	}
	
	
	
	
	
}
