package com.cognizant.expenseSeverity.service;

import com.cognizant.expenseSeverity.exception.InvalidChoiceException;
import com.cognizant.expenseSeverity.model.SeverityResponse;

public interface ExecutionService {

	public SeverityResponse expenseSeverityStatus(String token, String username) throws InvalidChoiceException;
	
}
