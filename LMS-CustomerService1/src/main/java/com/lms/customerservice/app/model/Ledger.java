package com.lms.customerservice.app.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ledger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer ledgerId;
	public Date ledgerCreatedDate;
	public Double totalLoanAmount;
	public Double payableAmountwithInterest;
	public Integer tenure;
	public Double 	monthlyEMI;
	public Double amountPaidtillDate;
	public Double 	remainingAmount;
	public String nextEmiDatestart;
	public String nextEmiDateEnd;
	public Integer defaulterCount;
	public String previousEmiStatus;
	public String currentMonthEmiStatus;
	public String loanEndDate;
	public String loanStatus;
	
	
	 @ManyToOne(cascade = CascadeType.ALL) 
	 private CustomerDetails customerDetails;
	 
}
