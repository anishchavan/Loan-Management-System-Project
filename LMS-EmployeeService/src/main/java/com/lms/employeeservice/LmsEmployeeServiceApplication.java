package com.lms.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class LmsEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsEmployeeServiceApplication.class, args);
	}

}
