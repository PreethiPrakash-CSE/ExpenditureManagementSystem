package com.cognizant.target;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
public class TargetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetServiceApplication.class, args);
	}

}
