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
public class CustomerBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer bankDetailsId;
	 private String accountHolderName;
	  private String bankName;   
	  private long bankAccountNumber;
	  private String ifscCode;
	  

}
