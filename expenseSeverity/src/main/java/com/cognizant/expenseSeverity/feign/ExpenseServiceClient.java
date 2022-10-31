package com.cognizant.expenseSeverity.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.expenseSeverity.model.ExpenseDetails;

@FeignClient(name="expense-service", url="http://localhost:8081/expense")
public interface ExpenseServiceClient {
	@GetMapping("/getExpenses/{username}")
	 public List<ExpenseDetails> getExpenses(@RequestHeader(name = "Authorization") String token,@PathVariable String username);

}
