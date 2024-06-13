package com.lms.customerservice.app.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lms.customerservice.app.exception.Base64Deserializer;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDocuments implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer documentId;
	    @Lob
	    @Column(length = 100000)
	    @JsonDeserialize(using = Base64Deserializer.class)
		private byte[] panCard;
	    @Lob
	    @Column(length = 100000)
	    @JsonDeserialize(using = Base64Deserializer.class)
		private byte[] aadharCard;
	    @Lob
	    @Column(length = 100000)
	    @JsonDeserialize(using = Base64Deserializer.class)
		private byte[] photo;
	    @Lob
	    @Column(length = 100000)
	    @JsonDeserialize(using = Base64Deserializer.class)
		private byte[] salarySlips;
	    @Lob
	    @Column(length = 100000)
	    @JsonDeserialize(using = Base64Deserializer.class)
		private byte[] bankStatement;

}
