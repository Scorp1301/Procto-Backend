package com.org.alltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.alltech.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
