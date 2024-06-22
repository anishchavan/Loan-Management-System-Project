package com.lms.customerservice.app.exceptionhandler;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.lms.customerservice.app.exception.CustomerNotFound;
import com.lms.customerservice.app.response.ApiErrorResponse;
@RestControllerAdvice
public class CustomerExceptionHandler {
	  @ExceptionHandler(value=CustomerNotFound.class)
			public ResponseEntity<ApiErrorResponse> customerNotFound(){
				ApiErrorResponse apir= new ApiErrorResponse(404,"Customer Not Found",new Date());

				return new ResponseEntity<ApiErrorResponse>(apir,HttpStatus.NOT_FOUND);		
			}

}