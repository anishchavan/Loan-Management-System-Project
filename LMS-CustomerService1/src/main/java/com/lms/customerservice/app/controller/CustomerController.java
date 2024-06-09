package com.lms.customerservice.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.customerservice.app.exception.CustomerNotFound;
import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.model.CustomerDocuments;
import com.lms.customerservice.app.repository.CustomerRepository;
import com.lms.customerservice.app.response.BaseResponse;
import com.lms.customerservice.app.servicei.CustomerServiceI;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired CustomerServiceI csi;
	@Autowired CustomerRepository cr;
	
	@PostMapping(value="/saveCustomer",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<BaseResponse<CustomerDetails>> saveCustomerData(@RequestPart("jsondata")String alldata,
			@RequestPart("panCard") MultipartFile file1,
			@RequestPart("aadharCard") MultipartFile file2,
			@RequestPart("photo") MultipartFile file3,
			@RequestPart("salarySlips") MultipartFile file4,
			@RequestPart("bankStatement") MultipartFile file5,
			@RequestPart("sanctionLetter") MultipartFile file6){
		
		ObjectMapper om=new ObjectMapper();
		BaseResponse bs=null;
		try {
			
			CustomerDetails cd = om.readValue(alldata,CustomerDetails.class);
			
			cd.getCustomerDocuments().setPanCard(file1.getBytes());
			cd.getCustomerDocuments().setAadharCard(file2.getBytes());
			cd.getCustomerDocuments().setPhoto(file3.getBytes());
			cd.getCustomerDocuments().setSalarySlips(file4.getBytes());
			cd.getCustomerDocuments().setBankStatement(file5.getBytes());
			cd.getSanctionLetter().setSanctionLetter(file6.getBytes());
			
			
		CustomerDetails	 customer=csi.saveCustomerDetails(cd);
		System.out.println(customer);
		bs = new BaseResponse<>(201, "Data Saved",customer);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new ResponseEntity<BaseResponse<CustomerDetails>> (bs,HttpStatus.CREATED);
	}
	
	@GetMapping("/getCustomers")
	public ResponseEntity<BaseResponse<Iterable<CustomerDetails>>> getCustomerDetails(){
		Iterable<CustomerDetails> customerList=csi.getCustomerDetails();
		if(customerList!=null) {
			BaseResponse bs=new BaseResponse(200,"All data get",customerList);
		return new ResponseEntity<BaseResponse<Iterable<CustomerDetails>>>(bs,HttpStatus.OK);
		}
		else {
			throw new CustomerNotFound();
		}
		}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<BaseResponse<CustomerDetails>> deleteCustomer(@PathVariable int customerId){
		Optional<CustomerDetails> customerDetails=cr.findById(customerId);
		if(customerDetails.isPresent()) {
			csi.deleteCustomer(customerId);
			BaseResponse bs = new BaseResponse<>(200, "Data Deleted Successfully", customerDetails);
 return new ResponseEntity<BaseResponse<CustomerDetails>>(bs,HttpStatus.OK);
		}
		else {
			 throw new CustomerNotFound();
		}}
	
	
	
}
