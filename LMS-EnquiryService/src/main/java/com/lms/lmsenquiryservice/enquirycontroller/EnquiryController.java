package com.lms.lmsenquiryservice.enquirycontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.lmsenquiryservice.enquiryservicei.EnquiryServiceI;
import com.lms.lmsenquiryservice.enums.CibilStatus;
import com.lms.lmsenquiryservice.model.Enquiry;

@RestController
public class EnquiryController {
	@Autowired
	EnquiryServiceI esi;
	
	Logger log = LoggerFactory.getLogger(EnquiryController.class);
	
	@PostMapping("/applicant")
	public ResponseEntity<Enquiry> registerApplicant(@RequestBody Enquiry e){
		e.setCibilStatus(String.valueOf(CibilStatus.pending));
		Enquiry enquiry = esi.registerApplicant(e);
		log.info("Applicant has been registered successfully..");
		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.CREATED);
	}
	
	@GetMapping("/applicants")
	public ResponseEntity<List<Enquiry>> getApplicants(){
		List<Enquiry> aList= esi.getApplicants();
		  log.info("{}", aList);
		  log.info("The enquiries has been retrieved successfully");
		return new ResponseEntity<List<Enquiry>>(aList, HttpStatus.OK);
	}
}
