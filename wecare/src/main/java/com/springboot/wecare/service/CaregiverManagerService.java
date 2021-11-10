package com.springboot.wecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.wecare.model.CaregiverManager;
import com.springboot.wecare.repository.CaregiverManagerRepository;

@Service
public class CaregiverManagerService implements ICaregiverManagerService {
	
	@Autowired
	CaregiverManagerRepository caregiverManagerRepository;

	@Override
	@Transactional
	public List<CaregiverManager> getManagers() {
		
		List<CaregiverManager> managerList;
	  try {
		  managerList = caregiverManagerRepository.findAll();
	  }
	  catch(Exception e)
	  {
		  return null;
	  }
		
		return managerList ;
	}

}
