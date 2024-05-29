package com.lms.lmsenquiryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class LmsEnquiryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsEnquiryServiceApplication.class, args);
	}

}
