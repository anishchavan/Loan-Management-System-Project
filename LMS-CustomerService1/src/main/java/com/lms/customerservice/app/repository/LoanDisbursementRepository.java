package com.lms.customerservice.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.model.LoanDisbursement;

public interface LoanDisbursementRepository extends JpaRepository<LoanDisbursement, Integer>{

	

}
