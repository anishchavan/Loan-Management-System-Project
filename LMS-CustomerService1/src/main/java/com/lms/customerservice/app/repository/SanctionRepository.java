package com.lms.customerservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.customerservice.app.model.SanctionLetter;


@Repository
public interface SanctionRepository extends JpaRepository<SanctionLetter, Integer> {

}
