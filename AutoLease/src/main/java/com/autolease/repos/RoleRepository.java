package com.autolease.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolease.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

}
