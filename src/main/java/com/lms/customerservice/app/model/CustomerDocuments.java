package com.lms.customerservice.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDocuments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer documentId;
	    @Lob
	    @Column(length = 100000)
		private byte[] panCard;
	    @Lob
	    @Column(length = 100000)
		private byte[] aadharCard;
	    @Lob
	    @Column(length = 100000)
		private byte[] photo;
	    @Lob
	    @Column(length = 100000)
		private byte[] salarySlips;
	    @Lob
	    @Column(length = 100000)
		private byte[] bankStatement;

}
