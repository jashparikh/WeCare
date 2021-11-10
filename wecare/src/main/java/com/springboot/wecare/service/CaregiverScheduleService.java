package com.springboot.wecare.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.wecare.model.Caregiver;
import com.springboot.wecare.model.CaregiverSchedule;
import com.springboot.wecare.repository.CaregiverRepository;
import com.springboot.wecare.repository.CaregiverScheduleRepository;
@Service
public class CaregiverScheduleService implements ICaregiverScheduleService {

	@Autowired
	CaregiverScheduleRepository caregiverScheduleRepository;
	CaregiverRepository caregiverRepository;

	public List<CaregiverSchedule> getAllEmployeeSchedules() {
		return caregiverScheduleRepository.findAll();
	}

	public List<CaregiverSchedule> getEmployeeSchedule(long caregiverId){
		List<CaregiverSchedule> allCgSch = getAllEmployeeSchedules();
		List<CaregiverSchedule> cgSch = new ArrayList<CaregiverSchedule>();
		for (CaregiverSchedule cg : allCgSch) {
			if (cg.getCaregiverid()==caregiverId) {
				cgSch.add(cg);
			}
		}
		return cgSch;
	}

	public List<Caregiver> findAvailableFor(LocalDate date, int startTime, int endTime){
		List<CaregiverSchedule> allCgSch = getAllEmployeeSchedules();
		List<Caregiver> cgList = new ArrayList<Caregiver>();
		for (CaregiverSchedule cg : allCgSch) {
			if (cg.getDate()==date && cg.getStartTime()<startTime && cg.getEndTime() > endTime) {
				//add condition to check that they don't already have an appointment
				cgList.add(caregiverRepository.getById(cg.getCaregiverid()));
			}
		}
		return cgList;
	}

	public String addShift(CaregiverSchedule cgSch) {
		try {
			caregiverScheduleRepository.save(cgSch);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Shift Added";
	}

	public String removeShift(long cgSchId) {
		try {
			caregiverScheduleRepository.deleteById(cgSchId);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Shift Removed";
	}
}
