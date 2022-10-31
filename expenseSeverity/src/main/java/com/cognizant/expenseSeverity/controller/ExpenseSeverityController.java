package com.cognizant.expenseSeverity.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.expenseSeverity.exception.InvalidChoiceException;
import com.cognizant.expenseSeverity.feign.AuthClient;
import com.cognizant.expenseSeverity.model.SeverityResponse;
import com.cognizant.expenseSeverity.service.ExecutionService;

@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
@RequestMapping("/severity")
public class ExpenseSeverityController {
	
	@Autowired
	private ExecutionService service;
	
	@Autowired
	private AuthClient client;
	
	@GetMapping("/expenditureStatus/{username}")
	public ResponseEntity<SeverityResponse> projectExecutionStatus(@RequestHeader(name = "Authorization") String token,@PathVariable String username) throws InvalidChoiceException {
		try {
		
		if(client.validate(token)) {
			return new ResponseEntity<>(this.service.expenseSeverityStatus(token,username),HttpStatus.OK);
		} 
		else {
			throw new InvalidChoiceException("InvalidChoice");
		}
		} 
		catch (Exception e) {
			throw new InvalidChoiceException("InvalidChoice");
		}
	}

}
