package com.springboot.wecare.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.wecare.model.FirstTimeAppointment;
import com.springboot.wecare.service.IFirstTimeAppointmentService;

@RestController
public class FirstTimeAppointmentController {
	@Autowired
	IFirstTimeAppointmentService firstTimeService;

	@GetMapping("/allFirstTimeAppointments")
	public List<FirstTimeAppointment> getAllFirstTimeAppointments() {
		System.out.println("Get all data..");

		return firstTimeService.getAll();
	}

	@CrossOrigin
	@PostMapping("/addFirstAppointment")
	public String requestFirstAppointment(@RequestBody @Valid FirstTimeAppointment firstTimeAppointment) {

		String res = firstTimeService.requestFirstAppointment(firstTimeAppointment);
		return res;

	}

	@CrossOrigin
	@PutMapping("/cancelFirstAppointment")

	public String cancelFirstAppointment(@RequestBody @Valid Long firsttimeappointmentId) {
		String response = firstTimeService.cancelFirstAppointment(firsttimeappointmentId);

		return response;
	}

}