package com.lms.lmsenquiryservice.enquirycontroller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lms.lmsenquiryservice.enquiryservicei.EnquiryServiceI;
import com.lms.lmsenquiryservice.enums.CibilStatus;
import com.lms.lmsenquiryservice.exceptions.EnquiryNotFound;
import com.lms.lmsenquiryservice.model.Enquiry;
import com.lms.lmsenquiryservice.response.BaseResponse;

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
	
	@GetMapping("/getEnquiry/{CIBILStatus}") 
	public ResponseEntity<BaseResponse<Iterable<Enquiry>>> getEnquiry(@PathVariable("CIBILStatus") String CIBILStatus)
	{
		Enquiry eq=null;
		
		 Iterable<Enquiry> enq = esi.getEnquiry(CIBILStatus);
		 for(Enquiry enq1:enq) {
			 if(enq1 !=null) {
				 eq=enq1;
			 }
		 }
		 if(eq !=null) {
		 BaseResponse<Iterable<Enquiry>> ba= new BaseResponse<>(200,"All data Ok",enq);
		 return new ResponseEntity<BaseResponse<Iterable<Enquiry>>>(ba,HttpStatus.OK) ;
		 }else {
		 throw new EnquiryNotFound();
		 }	
		 
	}
	
	@GetMapping("/getSingleEnquiry/{applicantId}")
	public ResponseEntity<BaseResponse<Enquiry>> getSingleEnquiry(@PathVariable Integer applicantId){
		Optional<Enquiry> singleEnquiry = esi.getSingleEnquiry(applicantId);
		if(singleEnquiry.isPresent()) {
			BaseResponse ba= new BaseResponse<>(200,"All data Ok",singleEnquiry);
			return new ResponseEntity<BaseResponse<Enquiry>>(ba,HttpStatus.OK);
			
		}else {
			throw new EnquiryNotFound();
		}
	}
	
	@PutMapping("/checkCibil/{enquiryId}")
	public ResponseEntity<BaseResponse<Enquiry>> checkCibilScore(@PathVariable("enquiryId") Integer enquiryId,@RequestBody Enquiry enq)
	{
		Random ramdom=new Random();
		int cibilScore = ramdom.nextInt(300, 900);
		
		if(cibilScore>=600 && cibilScore<=900) 
		{
			enq.setCibilStatus(String.valueOf(CibilStatus.approved));
			enq.setCibilScore(cibilScore);
		
		    Enquiry enquiry = esi.registerApplicant(enq);

		    BaseResponse<Enquiry> baseResponse = new BaseResponse<Enquiry>(200,"CIBIL Approved",enquiry);
			return new ResponseEntity<BaseResponse<Enquiry>>(baseResponse,HttpStatus.OK);
		}
		else
		{
			enq.setCibilStatus(String.valueOf(CibilStatus.rejected));
			enq.setCibilScore(cibilScore);
			
			Enquiry enquiry = esi.registerApplicant(enq);
			
	        BaseResponse<Enquiry> baseResponse = new BaseResponse<Enquiry>(200,"CIBIL Rejected",enquiry);
			return new ResponseEntity<BaseResponse<Enquiry>>(baseResponse,HttpStatus.OK);
		}
		
	

}
}
