package com.springboot.wecare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.wecare.model.ClientSchedule;
import com.springboot.wecare.repository.ClientScheduleRepository;

@Service
public class ClientScheduleService implements IClientScheduleService{
	
	@Autowired
	ClientScheduleRepository clientScheduleRepository;

	@Override
	public List<Long> getClientSchedule(Long clientId) {
		List<ClientSchedule> clientScheduleList;
		List<Long> finalClientScheduleList=new ArrayList();
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
	


}
