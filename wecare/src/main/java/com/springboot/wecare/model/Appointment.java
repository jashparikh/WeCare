package com.springboot.wecare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointment {

	@Id
	@Column(name = "appointment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;

	@Column(name = "appointment_date")
	private String appointmentDate;

	@Column(name = "appointment_frequency")
	private String appointmentFrequency;

	@Column(name = "appointment_length")
	private String appointmentLength;

	@Column(name = "appointment_duration")
	private String appointmentDuration;

	@Column(name = "client_id")
	private Long clientID;

	@Column(name = "caregiver_id")
	private int caregiverID;

	@Column(name = "manager_id")
	private int managerID;

	@Column(name ="is_confirmed")
	private String isConfirmed;
	
	@Column(name ="schedule_id")
	private  Long scheduleID;

	public Appointment() {
		super();
	}

	public Appointment(Long appointmentId, String appointmentDate, String appointmentFrequency,
			String appointmentLength, String appointmentDuration, Long clientID, int caregiverID, int managerID,
			String isConfirmed, Long scheduleID) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentFrequency = appointmentFrequency;
		this.appointmentLength = appointmentLength;
		this.appointmentDuration = appointmentDuration;
		this.clientID = clientID;
		this.caregiverID = caregiverID;
		this.managerID = managerID;
		this.isConfirmed = isConfirmed;
		this.scheduleID = scheduleID;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentFrequency() {
		return appointmentFrequency;
	}

	public void setAppointmentFrequency(String appointmentFrequency) {
		this.appointmentFrequency = appointmentFrequency;
	}

	public String getAppointmentLength() {
		return appointmentLength;
	}

	public void setAppointmentLength(String appointmentLength) {
		this.appointmentLength = appointmentLength;
	}

	public String getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(String appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public int getCaregiverID() {
		return caregiverID;
	}

	public void setCaregiverID(int caregiverID) {
		this.caregiverID = caregiverID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(String isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public Long getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(Long scheduleID) {
		this.scheduleID = scheduleID;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
				+ ", appointmentFrequency=" + appointmentFrequency + ", appointmentLength=" + appointmentLength
				+ ", appointmentDuration=" + appointmentDuration + ", clientID=" + clientID + ", caregiverID="
				+ caregiverID + ", managerID=" + managerID + ", isConfirmed=" + isConfirmed + ", scheduleID="
				+ scheduleID + "]";
	}

}