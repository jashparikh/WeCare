package com.springboot.wecare.service;

public interface IFirstTimeAppointmentService {

	public String requestFirstAppointment(Long clientId, String appointmentDuration);
	
	public String cancelFirstAppointment (Long clientId, String appointmentDuration);
}
