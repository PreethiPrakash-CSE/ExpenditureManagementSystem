package com.cognizant.expense.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="expense-authorization-service", url="http://localhost:8080/authorization")
public interface AuthClient {

	@GetMapping("/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token1);
	
}
