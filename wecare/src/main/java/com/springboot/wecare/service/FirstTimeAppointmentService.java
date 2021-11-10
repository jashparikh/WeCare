package com.springboot.wecare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.wecare.model.Appointment;
import com.springboot.wecare.model.Client;
import com.springboot.wecare.model.FirstTimeAppointment;
import com.springboot.wecare.repository.ClientRepository;
import com.springboot.wecare.repository.FirstTimeAppointmentRepository;

@Service
public class FirstTimeAppointmentService implements IFirstTimeAppointmentService{

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	FirstTimeAppointmentRepository firstTimeAppointmentRepository;
	
	
	@Transactional
	public String requestFirstAppointment(Long clientId, String appointmentDuration) {
		FirstTimeAppointment first = new FirstTimeAppointment();
		first.setClientId(clientId);
		first.setAppointmentDuration(appointmentDuration);
		
			try {		 
				firstTimeAppointmentRepository.save(first);
				
			}catch (Exception e) {
				
				return e.getMessage();
			}
		
		return "Appointment Created";
	}

	@Transactional
	public String cancelFirstAppointment(Long clientId, String appointmentDuration) {
		
		
		return null;
	}

	
}
