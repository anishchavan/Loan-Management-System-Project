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
public class PreviousLoanDetails {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	 private Integer previousLoandetailsId;
	 private Double loanAmount;
	 private Long loanTenure;
	 private long paidAmount;
	 private long remainingAmount;
	 private String bankName;


}
