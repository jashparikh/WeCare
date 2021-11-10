package com.springboot.wecare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.wecare.model.Caregiver;

import com.springboot.wecare.repository.CaregiverRepository;


@Service
public class CaregiverService implements ICaregiverService {
	@Autowired
	CaregiverRepository caregiverRepository;

	public List<Caregiver> getAll() {
		return caregiverRepository.findAll();

	}

	public String addCaregiver(Caregiver caregiver) {

		try {
			caregiverRepository.save(caregiver);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Caregiver Saved";
	}

	


	@Transactional
	public String updateCaregiver(Caregiver caregiver) {

			Optional<Caregiver> searchrecord = caregiverRepository.findByCaregiverid(caregiver.getCaregiverid());
			
			if (searchrecord.isPresent()) {
				try {
					Caregiver UpdateCaregiver= searchrecord.get();
					
					UpdateCaregiver.setCaregiverName(caregiver.getCaregiverName());
					UpdateCaregiver.setCaregiverExperience(caregiver.getCaregiverExperience());
					UpdateCaregiver.setCaregiverSpecialization(caregiver.getCaregiverSpecialization());
					UpdateCaregiver.setCaregiverAbout(caregiver.getCaregiverAbout());
					UpdateCaregiver.setCaregiverEmail(caregiver.getCaregiverEmail());
					UpdateCaregiver.setCaregiverReview(caregiver.getCaregiverReview());
					UpdateCaregiver.setCaregiverDob(caregiver.getCaregiverDob());
					UpdateCaregiver.setCaregiverContactNo(caregiver.getCaregiverContactNo());
					UpdateCaregiver.setAddressId(caregiver.getAddressId());
					UpdateCaregiver.setLoginId(caregiver.getLoginId());
				
					
					caregiverRepository.save(UpdateCaregiver);
				} 
				
				catch (Exception e) {			
			return e.getMessage();			
		}   
			}			
			else {
			return "No record exist";
		}
		return "Caregiver Updated";
	}


	@Transactional
	public String deleteCaregiver(String caregiverContactNo) {
		try {
			Optional<Caregiver> caregiver = caregiverRepository.findByCaregiverContactNo(caregiverContactNo);
			caregiverRepository.delete(caregiver.get());
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Caregiver Deleted";	
		
	}

	@Override
	public void RequestAppoinmentCancellation() {
		

			} 
	
	
	/*public abstract void login(Caregiver caregiver);
	public abstract void Firsttimelogin();
	public abstract void RequestAppoinmentCancellation();
	public abstract void viewChatSupportContactDetails();
	public abstract void viewCallSupportContactDetails();
	public abstract void viewAppointments();
	public abstract void viewPatientInfo();
	public abstract void viewAppointmentHistory();
	public abstract void viewProfileInfo();
	public abstract void UpdateProfileInfo();
	public abstract void resetPassword();*/
}