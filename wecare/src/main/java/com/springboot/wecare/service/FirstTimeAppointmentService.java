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
		Optional <FirstTimeAppointment> searchRecord = clientRepository.findById(clientId.getClientId()); // error to be resolved when clientId is as Long
		
		if(searchRecord.isPresent()) {
			try {
				
				FirstTimeAppointment updateFirstTimeAppointment = searchRecord.get();
				
				updateFirstTimeAppointment.setAppointmentDuration(appointmentDuration);
				updateFirstTimeAppointment.setClientId(clientId);
				
				firstTimeAppointmentRepository.save(updateFirstTimeAppointment);
				
			}catch (Exception e) {
				return e.getMessage();
			}
		}else {
			return "Client Doesn't Exist";
	} 
		return "First Appointment Saved";
	}
		return null;
	}

	@Transactional
	public String cancelFirstAppointment(Long clientId, String appointmentDuration) {
		
		
		return null;
	}

	
}
