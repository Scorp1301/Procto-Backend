package com.org.alltech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.alltech.entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>  {
	List<Appointment> findByPatientId(Integer patientId);
}
