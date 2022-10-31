package com.cognizant.expenseSeverity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExpenseSeverityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseSeverityApplication.class, args);
	}

}
