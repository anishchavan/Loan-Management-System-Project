package com.lms.customerservice.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employerId;	
	private String employerName;
	private long employerContact;
	private String employerEmail;
	private int workingFrom;
	private String designation;
	private String orgType;  //(pri/gov)
	private double monthlyIncome;



}
