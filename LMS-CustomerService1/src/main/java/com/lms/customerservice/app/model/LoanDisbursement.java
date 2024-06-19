package com.lms.customerservice.app.model;

import java.util.Date;

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
public class LoanDisbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer agreementId;
	private Date agreementDate;
	private Double totalLoanSanctionedAmount;
	private Double transferedAmount;
	private String amountPaidDate;
	private String paymentStatus;
	private String bankName;
	private Long bankAccountNumber;
	private String bankIfscCode;
	private String accountType;


}
