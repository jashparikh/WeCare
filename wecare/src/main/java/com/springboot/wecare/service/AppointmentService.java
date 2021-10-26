package com.springboot.wecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.wecare.model.Appointment;
import com.springboot.wecare.repository.AppointmentRepository;
@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	public List<Appointment> getAll() {
		return appointmentRepository.findAll();
	}

	public String addAppointment(Appointment appointment) {
		try {
			appointmentRepository.save(appointment);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Appointment Saved";
	}
	}
