package com.lms.lmsenquiryservice.enquirycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.lmsenquiryservice.enquiryservicei.EnquiryServiceI;
import com.lms.lmsenquiryservice.model.Enquiry;

@RestController
public class EnquiryController {
	@Autowired
	EnquiryServiceI esi;
	@PostMapping("/applicant")
	public ResponseEntity<Enquiry> registerApplicant(@RequestBody Enquiry e){
		Enquiry enquiry = esi.registerApplicant(e);
		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.CREATED);
	}
}
