package com.org.alltech.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.alltech.entity.Doctor;
import com.org.alltech.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        if (doctorRepository.existsById(id)) {
            updatedDoctor.setDoctorid(id);
            return doctorRepository.save(updatedDoctor);
        }
        return null; // Handle not found
    }

    
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    
    public List<Doctor> getAllDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

}
