package com.lms.lmsconsumer.consumercontroller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;

import com.lms.lmsconsumer.model.Employee;
import com.lms.lmsconsumer.model.Enquiry;
import com.lms.lmsconsumer.response.BaseResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/register")
public class ConsumerController {
	@Autowired
	RestTemplate rt;
	
	
	Logger log = LoggerFactory.getLogger(ConsumerController.class);
	
	@PostMapping("/applicant")
	public ResponseEntity<Enquiry> registerApplicant(@RequestBody Enquiry e){
		String url = "http://zuul/enquiry/applicant";
		Enquiry enq = rt.postForObject(url, e, Enquiry.class);
		log.info("Applicant has been registered successfully...");
		return new ResponseEntity<Enquiry>(enq,HttpStatus.CREATED);
	}
	
	@GetMapping("/applicants")
	public ResponseEntity<List<Enquiry>> getApplicants(){
		String url = "http://zuul/enquiry/applicants";
		ResponseEntity<List<Enquiry>> responseEntity = rt.exchange(
		        url,
		        HttpMethod.GET,
		        null,
		        new ParameterizedTypeReference<List<Enquiry>>() {}
		    );

		    List<Enquiry> aList = responseEntity.getBody();
		    log.info("{}", aList);
		    log.info("The enquiries has been retrieved successfully");
		    System.out.println(aList);
		    return new ResponseEntity<List<Enquiry>>(aList, HttpStatus.OK);
		
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee e){
		String url = "http://zuul/employee/employee";
		rt.postForObject(url, e, Employee.class);
		log.info("Employee has been saved successfully");
		return new ResponseEntity<Employee>(HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		String url = "http://zuul/employee/employees";		
		ResponseEntity<List<Employee>> responseEntity = rt.exchange(
		        url,
		        HttpMethod.GET,
		        null,
		        new ParameterizedTypeReference<List<Employee>>() {}
		    );

		    List<Employee> eList = responseEntity.getBody();
		    log.info("{}", eList);
		    log.info("The employees has been retrieved successfully");
		    System.out.println(eList);
		    return new ResponseEntity<List<Employee>>(eList, HttpStatus.OK);
	}
	
	@GetMapping("/login/{un}/{ps}")
	public ResponseEntity<Employee> loginEmployee(@PathVariable String un, @PathVariable String ps){
		String url="http://zuul/employee/login/"+ un +"/"+ ps;
		Employee emp = rt.getForObject(url, Employee.class);
		log.info("The employee has successfully logged in");
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
//	@GetMapping("/enquiries/{cibilStatus}")
//	public ResponseEntity<BaseResponse<Iterable<Enquiry>>> getEnquiries(@PathVariable String cibilStatus){
//	    String url = "http://zuul/enquiry/getEnquiry/" + cibilStatus;
//	    ResponseEntity<BaseResponse<Iterable<Enquiry>>> responseEntity = rt.exchange(
//	        url,
//	        HttpMethod.GET,
//	        null,
//	        new ParameterizedTypeReference<BaseResponse<Iterable<Enquiry>>>() {}
//	    );
//
//	    BaseResponse<Iterable<Enquiry>> baseResponse = responseEntity.getBody();
//	    log.info("{}", baseResponse.getResponseData());
//	    log.info("The enquiries has been retrieved successfully");
//	    System.out.println(baseResponse.getResponseData());
//
//	    return new ResponseEntity<BaseResponse<Iterable<Enquiry>>>(baseResponse, HttpStatus.OK);
//	}
	
	@GetMapping("/enquiries/{cibilStatus}")
	public Iterable<Enquiry> getEnquiries(@PathVariable String cibilStatus){
	    String url = "http://zuul/enquiry/getEnquiry/" + cibilStatus;
	    
	    Iterable<Enquiry> forObject = rt.getForObject(url, Iterable.class);
	   
	    return forObject;
	}
	
//	@PutMapping("/checkCibilScore/{applicantId}")
//	public Enquiry checkCibilScore(@PathVariable("applicantId") Integer applicantId, @RequestBody Enquiry enq) {
//	    String url = "http://zuul/enquiry/checkCibil/" + applicantId;
//	    Enquiry response=rt.put(url,enq,applicantId);
//        return response;
//	   
//	}
//	
	@GetMapping("/getEnquiry/{applicantId}")
	public ResponseEntity<BaseResponse<Enquiry>> getSingleEnquiry(@PathVariable Integer applicantId){
		String url = "http://zuul/enquiry/getSingleEnquiry/" + applicantId;
		ResponseEntity<BaseResponse<Enquiry>> responseEntity = rt.exchange(
		        url,
		        HttpMethod.GET,
		        null,
		        new ParameterizedTypeReference<BaseResponse<Enquiry>>() {}
		    );

		 BaseResponse<Enquiry>baseResponse = responseEntity.getBody();
		    log.info("{}", baseResponse.getResponseData());
		    log.info("The single enquiry has been retrieved successfully");
		    System.out.println(baseResponse.getResponseData());

		    return new ResponseEntity<BaseResponse<Enquiry>>(baseResponse, HttpStatus.OK);
	}
	
//	@PutMapping("/checkCibilScore/{enquiryId}")
//	public ResponseEntity<BaseResponse<Enquiry>> checkCibilScore(@PathVariable("enquiryId") Integer enquiryId, @RequestBody Enquiry enq) {
//	    String url = "http://zuul/enquiry/checkCibil/" + enquiryId;
//	    HttpEntity<Enquiry> requestEntity = new HttpEntity<>(enq);
//
//	    ResponseEntity<BaseResponse<Enquiry>> responseEntity = rt.exchange(
//	        url,
//	        HttpMethod.PUT,
//	        requestEntity,
//	        new ParameterizedTypeReference<BaseResponse<Enquiry>>() {}
//	    );
//
//	    BaseResponse<Enquiry> baseResponse = responseEntity.getBody();
//	    if (baseResponse != null) {
//	        log.info("{}", baseResponse.getResponseData());
//	        log.info("CIBIL check response: {}", baseResponse.getMessage());
//
//	        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    }
//	}
	@GetMapping("/getPending")
	public ResponseEntity<BaseResponse<Iterable<Enquiry>>> getPendingEnquiries(){
	    String url = "http://zuul/enquiry/getPendingEnquiry";
	    ResponseEntity<BaseResponse<Iterable<Enquiry>>> responseEntity = rt.exchange(
	        url,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<BaseResponse<Iterable<Enquiry>>>() {}
	    );

	    BaseResponse<Iterable<Enquiry>> baseResponse = responseEntity.getBody();
	    log.info("{}", baseResponse.getResponseData());
	    log.info("The enquiries has been retrieved successfully");
	    System.out.println(baseResponse.getResponseData());

	    return new ResponseEntity<BaseResponse<Iterable<Enquiry>>>(baseResponse, HttpStatus.OK);
	}

	
	
}
