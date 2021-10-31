package com.springboot.wecare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.wecare.model.Caregiver;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {
	
	Optional<Caregiver> findByCaregiverContactNo(String caregiverContactNo);
	
	Optional<Caregiver> findByCaregiverid(int caregiverid);
}
