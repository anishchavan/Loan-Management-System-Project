package com.lms.lmsconsumer.consumercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lms.lmsconsumer.model.Enquiry;

@RestController
@RequestMapping("/register")
public class ConsumerController {
	@Autowired
	RestTemplate rt;
	@PostMapping("/applicant")
	public ResponseEntity<Enquiry> registerApplicant(@RequestBody Enquiry e){
		System.out.println("In Consumer controller");
		String url = "http://zuul/enquiry/applicant";
		rt.postForObject(url, e, Enquiry.class);
		return new ResponseEntity<Enquiry>(HttpStatus.CREATED);
	}
}
