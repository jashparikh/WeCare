package com.springboot.wecare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.wecare.model.Appointment;
@Repository

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	Optional<Appointment> findByAppointmentId(Long appointmentID);
}
