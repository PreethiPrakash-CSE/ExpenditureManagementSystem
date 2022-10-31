package com.cognizant.expenseSeverity.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.expenseSeverity.model.TargetDetails;

@FeignClient(name="target-service" , url = "http://localhost:8082/target")

public interface TargetBenchmarkClient {

	@GetMapping("/getTarget/{username}")
	public TargetDetails getTarget(@RequestHeader(name = "Authorization") String token1,@PathVariable String username);
	
}
