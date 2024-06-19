package com.lms.customerservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.customerservice.app.model.SanctionLetter;

public interface SanctionRepository extends JpaRepository<SanctionLetter, Integer> {

	
	
}
