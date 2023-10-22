package com.org.alltech.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.alltech.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUsername(String username);
	User findIDByUsername(String username);

}
