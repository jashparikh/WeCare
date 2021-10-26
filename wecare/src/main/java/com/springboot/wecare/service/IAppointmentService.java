package com.springboot.wecare.service;

import java.util.List;

import com.springboot.wecare.model.Appointment;

public interface IAppointmentService {
	public List<Appointment> getAll();

    public String addAppointment(Appointment appointment) ;
}
