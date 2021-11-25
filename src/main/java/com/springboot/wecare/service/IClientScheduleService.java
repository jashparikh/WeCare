package com.springboot.wecare.service;

import java.util.List;

import com.springboot.wecare.model.Appointment;

public interface IClientScheduleService {

	List<Long> getClientSchedule(Long clientId);

	List<Appointment> generateClientSchedule(long firstAptId);

}
