package com.springboot.wecare.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.wecare.model.Appointment;
import com.springboot.wecare.service.IAppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	IAppointmentService appointmentService;

	@GetMapping("/allAppointments")
	public List<Appointment> getAllBuyer() {
		System.out.println("Get all data..");

		return appointmentService.getAll();
	}

	@CrossOrigin
	@PostMapping("/addAppointment")
	public String addAppointment(@RequestBody @Valid Appointment appointment) {
		String contact = appointmentService.addAppointment(appointment);

		return contact;
	}
}
