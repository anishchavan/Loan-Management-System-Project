package com.lms.lmsenquiryservice.enquirycontroller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lms.lmsenquiryservice.enquiryservicei.EnquiryServiceI;
import com.lms.lmsenquiryservice.enums.cibilStatus;
import com.lms.lmsenquiryservice.exceptions.EnquiryNotFound;
import com.lms.lmsenquiryservice.model.Enquiry;
import com.lms.lmsenquiryservice.response.BaseResponse;

@CrossOrigin("*")
@RestController
public class EnquiryController {
	@Autowired
	EnquiryServiceI esi;
	
	Logger log = LoggerFactory.getLogger(EnquiryController.class);
	
	@PostMapping("/applicant")
	public ResponseEntity<Enquiry> registerApplicant(@RequestBody Enquiry e){
		e.setCibilStatus(String.valueOf(cibilStatus.pending));
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
//	
//	@GetMapping("/getEnquiry/{cibilStatus}") 
//	public Iterable<Enquiry> getEnquiry(@PathVariable("cibilStatus") String cibilStatus)
//	{
//		Enquiry eq=null;
//		
//		 Iterable<Enquiry> enq = esi.getEnquiry(cibilStatus);
//		 for(Enquiry enq1:enq) {
//			 if(enq1 !=null) {
//				 eq=enq1;
//			 }
//		 }
//		 if(eq !=null) {
//		
//		 return enq ;
//		 }else {
//		 throw new EnquiryNotFound();
//		 }	
//		 
//	}
	
	
	@GetMapping("/getEnquiry/{cibilStatus}") 
	public Iterable<Enquiry> getEnquiry(@PathVariable("cibilStatus") String cibilStatus)
	{
		return esi.getEnquiry(cibilStatus);		 
	}
	
	@GetMapping("/getsingleenquiry/{enqid}")
	public Optional<Enquiry> getSingleEnquiry(@PathVariable Integer enqid){
		Optional<Enquiry> singleEnquiry = esi.getSingleEnquiry(enqid);
		if(singleEnquiry.isPresent()) {
			
			return singleEnquiry;
			
		}else {
			throw new EnquiryNotFound();
		}
	}
	
	@PutMapping("/CheckCIBIL/{applicantId}")
	public Enquiry checkCibilScore(@PathVariable("applicantId") Integer applicantId,@RequestBody Enquiry enq)
	{
		Random ramdom=new Random();
		int cibilScore = ramdom.nextInt(300, 900);
		
		if(cibilScore>=600 && cibilScore<=900) 
		{
			enq.setCibilStatus(String.valueOf(cibilStatus.approved));
			enq.setCibilScore(cibilScore);
		
		    Enquiry enquiry = esi.registerApplicant(enq);

		
			return enquiry;
		}
		else
		{
			enq.setCibilStatus(String.valueOf(cibilStatus.rejected));
			enq.setCibilScore(cibilScore);
			
			Enquiry enquiry = esi.registerApplicant(enq);
			
			return enquiry;
		}
	}
	
	
}
