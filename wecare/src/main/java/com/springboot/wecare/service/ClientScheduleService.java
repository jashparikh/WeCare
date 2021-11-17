package com.springboot.wecare.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.wecare.model.Appointment;
import com.springboot.wecare.model.Caregiver;
import com.springboot.wecare.model.ClientSchedule;
import com.springboot.wecare.model.FirstTimeAppointment;
import com.springboot.wecare.repository.AppointmentRepository;
import com.springboot.wecare.repository.ClientScheduleRepository;
import com.springboot.wecare.repository.FirstTimeAppointmentRepository;

@Service
public class ClientScheduleService implements IClientScheduleService{
	
	@Autowired
	ClientScheduleRepository clientScheduleRepository;
	FirstTimeAppointmentRepository firstTimeAptRep;
	AppointmentRepository appointmentRep;
	
	@Override
	public List<Long> getClientSchedule(Long clientId) {
		List<ClientSchedule> clientScheduleList;
		List<Long> finalClientScheduleList=new ArrayList<Long>();
		clientScheduleList = clientScheduleRepository.findAll();
		
		for(ClientSchedule z :clientScheduleList)
		{
			if(z.getClientId()==clientId)
			{
				finalClientScheduleList.add(z.getClientScheduleId());
			}
		}
		// TODO Auto-generated method stub
		return finalClientScheduleList;
	}

	public List<Appointment> generateClientSchedule(long firstAptId){
			FirstTimeAppointment firstApt = firstTimeAptRep.getById(firstAptId);
			List<Appointment> listFinalApt = new ArrayList<Appointment>();
			int dur = Integer.parseInt(firstApt.getAppointmentDuration()); //number of days needed
			double freq = firstApt.getAppointmentFrequency(); //# per week, if >7 then one or multiple days will have two apt 
			//instead of frequency : let's set time apart from appointments (3 = every 3 days, 0.5 = every 12 hours)
			int length = firstApt.getAppointmentLength(); //how long will an appointment last? in minutes
			
			LocalDateTime tempDate = LocalDateTime.now().withHour(12).withMinute(0);
			LocalDateTime endDate = tempDate.plusDays(dur);
			
			List<LocalDateTime> neededAptDates = new ArrayList<LocalDateTime>();
			while (tempDate.isBefore(endDate)) {
				neededAptDates.add(tempDate);
				tempDate = tempDate.plusHours((long) freq*24);
			}
			CaregiverScheduleService css = new CaregiverScheduleService();
			for (LocalDateTime apt : neededAptDates) {
				int startTime = apt.getHour()*100+apt.getMinute();
				int endTime = apt.plusMinutes(length).getHour()*100+apt.plusMinutes(length).getMinute();
				List<Caregiver> available = css.findAvailableFor(apt.toLocalDate(), startTime, endTime);
				
				while (available.isEmpty()){
					apt.plusMinutes(30);
					startTime = apt.getHour()*100+apt.getMinute();
					endTime = apt.plusMinutes(length).getHour()*100+apt.plusMinutes(length).getMinute();
					available = css.findAvailableFor(apt.toLocalDate(), startTime, endTime);		
				}
				// next line randomly assigns a caregiver. will need to add the part where it actually asks the CGmanager to confirm
				Random random = new Random();
				Caregiver cg = available.get(random.nextInt(available.size()));
				
				ClientSchedule cs = new ClientSchedule();
				cs.setClientId(firstApt.getClientId());
				clientScheduleRepository.save(cs);
				
				Appointment appt = new Appointment((apt.toLocalDate()).toString(), startTime, length, firstApt.getClientId(), cg.getCaregiverid(), "False", cs.getClientScheduleId());	
				appointmentRep.save(appt);
				listFinalApt.add(appt);
			}
			
		return listFinalApt;
	}

}
