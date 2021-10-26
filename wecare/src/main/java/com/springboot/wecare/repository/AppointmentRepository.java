package com.springboot.wecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.wecare.model.Appointment;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
