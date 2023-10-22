package com.org.alltech.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.alltech.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	List<Admin> findByUsername(String username);

}
