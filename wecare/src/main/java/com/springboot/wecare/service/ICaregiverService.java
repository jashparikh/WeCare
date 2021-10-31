package com.springboot.wecare.service;

import java.util.List;

import com.springboot.wecare.model.Caregiver;


public interface ICaregiverService {
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
	
	public List<Caregiver> getAll();

    public String addCaregiver(Caregiver caregiver) ;
    
    public String updateCaregiver(Caregiver caregiver);
    
    public String deleteCaregiver(String caregiverContactNo);
    
    public abstract void RequestAppoinmentCancellation();

}
