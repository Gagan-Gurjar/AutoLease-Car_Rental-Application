package com.autolease.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolease.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
