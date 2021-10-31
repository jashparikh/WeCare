package com.springboot.wecare.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.wecare.model.Caregiver;

import com.springboot.wecare.service.ICaregiverService;


@RestController
public class CaregiverController {

	@Autowired
	ICaregiverService caregiverService;

	@GetMapping("/allCaregiver")
	public List<Caregiver> getAllBuyer() {
		System.out.println("Get all data..");

		return caregiverService.getAll();
	}

	@CrossOrigin
	@PostMapping("/addCaregiver")
	public String addCaregiver(@RequestBody @Valid Caregiver caregiver) {
		String contact = caregiverService.addCaregiver(caregiver);

		return contact;
	}

	@CrossOrigin
	@PutMapping("/UpdateCaregiver")
	public String UpdateCaregiver(@RequestBody @Valid Caregiver caregiver) {
		String response = caregiverService.updateCaregiver(caregiver);

		return response;
	}
	
	
	@CrossOrigin
	@DeleteMapping("/deleteCaregiver")
	public String deleteCaregiver(@RequestParam @Valid String caregiverContactNo) {
		String response = caregiverService.deleteCaregiver(caregiverContactNo);

		return response;
	}
	
}
