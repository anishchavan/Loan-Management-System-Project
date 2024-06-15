package com.lms.customerservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.model.SanctionLetter;
import com.lms.customerservice.app.servicei.SanctionServiceI;

@RestController
@RequestMapping("/sanction")
public class SanctionController {
	
	@Autowired
	SanctionServiceI ss;

	@PutMapping("/generatePdf/{customerId}")
	public CustomerDetails updateSactionLetter(@PathVariable int customerId, @RequestBody SanctionLetter sanctionLetter) {

			return ss.generateSactionId(customerId, sanctionLetter);
	}

}
