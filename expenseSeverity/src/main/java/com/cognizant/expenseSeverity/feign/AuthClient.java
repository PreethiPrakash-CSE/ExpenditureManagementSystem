package com.cognizant.expenseSeverity.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.expenseSeverity.model.IncomeDetails;

@FeignClient(name="expense-authorization-service", url="http://localhost:8080/authorization")
public interface AuthClient {

	
	@GetMapping("/validate")
	public Boolean validate(@RequestHeader(name = "Authorization") String token1);
	
	@GetMapping("/getIncome/{username}")
	 public IncomeDetails getIncome(@PathVariable String username);
	
}
