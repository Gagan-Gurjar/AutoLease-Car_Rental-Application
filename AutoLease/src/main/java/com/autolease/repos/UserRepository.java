package com.autolease.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolease.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
//	@Query("SELECT u FROM User u WHERE u.phone = :phone")
//	@Param("phone") String phone
	User findByPhone(String phone);
	
	User findByPhoneAndPassword(String phone, String password);
	
}
