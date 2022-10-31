package com.cognizant.expense.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.expense.feign.AuthClient;
import com.cognizant.expense.model.ExpenseDetails;
import com.cognizant.expense.service.ExpenseServiceImpl;

@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT})
@RestController
@RequestMapping("/expense")
public class ExpenseController {
	private final Logger log = LoggerFactory.getLogger(ExpenseController.class);
	
	@Autowired
	private AuthClient client;
	
	@Autowired
	private ExpenseServiceImpl expenseService;
	
	
	
	@PostMapping("/addExpense")
	public ResponseEntity<String> addExpense(@RequestHeader(name = "Authorization") String token,@RequestBody ExpenseDetails expense) {
		System.out.println("add Expense method");
		if(client.validate(token)) {
			if(log.isInfoEnabled()){
				log.info("In Expense controller!!!");
			}
			
			return expenseService.createExpense(expense);
		} 
		
		 
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		
	}
	
	@GetMapping("/getExpenses/{username}")
	 public ResponseEntity<List<ExpenseDetails>> getExpenses(@RequestHeader(name = "Authorization") String token,@PathVariable String username){
		System.out.println("get Expense method");
			if(client.validate(token)) {
				if(log.isInfoEnabled()){
					log.info("In expense controller!!!");
				}
				
				return new ResponseEntity<List<ExpenseDetails>>(expenseService.getExpenses(username),HttpStatus.OK);
			} 
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		
	}
	
	@DeleteMapping("/deleteExpenses/{username}")
	 public ResponseEntity<String> deleteExpenses(@RequestHeader(name = "Authorization") String token,@PathVariable String username){
		
			if(client.validate(token)) {
				if(log.isInfoEnabled()){
					log.info("In expense controller!!!");
				}
				
				
				return expenseService.deleteExpenses(username);
			} 
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		
	}
	
	
	
}
