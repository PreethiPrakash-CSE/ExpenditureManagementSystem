package com.cognizant.target.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.target.feign.AuthClient;
import com.cognizant.target.model.TargetDetails;
import com.cognizant.target.service.TargetServiceImpl;

@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT})
@RestController
@RequestMapping("/target")
public class TargetController {
	private final Logger log = LoggerFactory.getLogger(TargetController.class);
	
	@Autowired
	private AuthClient client;
	
	@Autowired
	private TargetServiceImpl targetService;
	
	
	
	@PostMapping("/setTarget")
	public ResponseEntity<String> addTarget(@RequestHeader(name = "Authorization") String token,@RequestBody TargetDetails target) {
		
		if(client.validate(token)) {
			if(log.isInfoEnabled()){
				log.info("In Expense controller!!!");
			}
			String result=targetService.setTarget(target);
			return new ResponseEntity<>(result,HttpStatus.OK);
		} 
		
		 
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		
	}
	
	@GetMapping("/getTarget/{username}")
	 public ResponseEntity<TargetDetails> getTarget(@RequestHeader(name = "Authorization") String token,@PathVariable String username){
		
			if(client.validate(token)) {
				if(log.isInfoEnabled()){
					log.info("In target controller!!!");
				}
				
				return new ResponseEntity<>(targetService.getTarget(username),HttpStatus.OK);
			} 
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		
	}
	
	@PutMapping("/updateTarget")
	public ResponseEntity<String> updateTarget(@RequestHeader(name = "Authorization") String token,@RequestBody TargetDetails target) {
		
		if(client.validate(token)) {
			if(log.isInfoEnabled()){
				log.info("In Expense controller!!!");
			}
			String result=targetService.updateTarget(target);
			return new ResponseEntity<>(result,HttpStatus.OK);
		} 
		
		 
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		
	}
	
	
	
	
	
}
