package com.lms.customerservice.app.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
	private Integer statusCode;
	private String errorMsg;
	private Date date;
}

;
