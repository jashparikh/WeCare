package com.springboot.wecare.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.wecare.model.CaregiverManager;
import com.springboot.wecare.model.Login;
import com.springboot.wecare.service.IAppointmentService;
import com.springboot.wecare.service.ICaregiverManagerService;
import com.springboot.wecare.service.IClientService;

@RestController
public class CaregiverManagerController {

	@Autowired
	ICaregiverManagerService caregiverManagerService;

	@Autowired
	IAppointmentService appointmentService;

	@Autowired // no need to add confirmations or properties for this class
	IClientService clientService; // reference of clientservice

	@GetMapping("/getManagers")
	public List<CaregiverManager> getManagers() {

		System.out.println("Get all data..");

		return caregiverManagerService.getManagers();
	}

	@CrossOrigin
	@DeleteMapping("/deleteClient")
	public String deleteClient(@RequestParam @Valid long clientId) {
		return clientService.removeClient(clientId);
	}

	@CrossOrigin
	@PutMapping("/cancelClientappointment")
	public String cancelClientAppointment(@RequestBody @Valid Login login) {
		String response = appointmentService.addAppointment(null);

		return response;
	}

}
