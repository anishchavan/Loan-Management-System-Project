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
public class GuarantorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer guarantorDetailsId;
	private String guarantorName;
	private String guarantorAddress;
	private long mobileNumber;
	private String designation;

}
