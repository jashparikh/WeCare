package com.springboot.wecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.wecare.model.Appointment;
import com.springboot.wecare.model.Caregiver;
import com.springboot.wecare.service.IClientScheduleService;

@RestController
public class ClientScheduleController {

	@Autowired
	IClientScheduleService clientScheduleService;
	
	@CrossOrigin
	@GetMapping("/findClientSchedule")
	public List<Long> findClientSchedule(Long clientId) {
		

		return clientScheduleService.getClientSchedule(clientId);
	}
	
	@CrossOrigin
	@GetMapping("/generateClientSchedule")
	public List<Appointment> generateClientSchedule(long firstAptId){
		return clientScheduleService.generateClientSchedule(firstAptId);
	}

}