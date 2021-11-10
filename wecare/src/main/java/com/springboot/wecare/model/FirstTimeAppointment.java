package com.springboot.wecare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="firstappointment")
public class FirstTimeAppointment {
	
	@Id
	@Column(name = "firstappointment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long firstappointmentId;
	
	@Column(name = "client_id")
	private Long clientId;
	
	@Column(name = "appointment_duration")
	private String appointmentDuration;

	public FirstTimeAppointment(Long firstappointmentId, Long clientId, String appointmentDuration) {
		super();
		this.firstappointmentId = firstappointmentId;
		this.clientId = clientId;
		this.appointmentDuration = appointmentDuration;
	}

	public Long getFirstappointmentId() {
		return firstappointmentId;
	}

	public void setFirstappointmentId(Long firstappointmentId) {
		this.firstappointmentId = firstappointmentId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(String appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	@Override
	public String toString() {
		return "FirstTimeAppointment [firstappointmentId=" + firstappointmentId + ", clientId=" + clientId
				+ ", appointmentDuration=" + appointmentDuration + "]";
	}
	

	
}