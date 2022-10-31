package com.cognizant.authorization.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authorization.exception.UserNotFoundException;
import com.cognizant.authorization.model.IncomeDetails;
import com.cognizant.authorization.model.MyUser;
import com.cognizant.authorization.model.UserCredentials;
import com.cognizant.authorization.service.UserDetailServiceImpl;
import com.cognizant.authorization.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT})
@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
	private final Logger log = LoggerFactory.getLogger(AuthorizationController.class);
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserCredentials userCredentials) {

		if (userCredentials.getUserName() == null || userCredentials.getPassword() == null
				|| userCredentials.getUserName().trim().isEmpty() || userCredentials.getPassword().trim().isEmpty()) {
			throw new UserNotFoundException("User name or password cannot be Null");
		}
		else {
			try {
				UserDetails user = userDetailsService.loadUserByUsername(userCredentials.getUserName());
				if (user.getPassword().equals(userCredentials.getPassword())) {
					String token = jwtUtil.generateToken(user.getUsername());
					if(log.isInfoEnabled()){
						log.info("Login successful");
					}
					return new ResponseEntity<>(token,HttpStatus.OK);
				} else {
					if(log.isInfoEnabled()){
						log.info("Login unsuccessful --> Invalid password");
					}
					
					throw new UserNotFoundException("Password is wrong");
				}
			} catch (Exception e) {
				if(log.isInfoEnabled()){
					log.info("Login unsuccessful --> Invalid Credential");
				}
				
				throw new UserNotFoundException("Invalid Credential");
			}
		}
	}
	
	@GetMapping("/validate")
	public ResponseEntity<Boolean> validate(@RequestHeader(name = "Authorization") String token1) {
		String token = token1.substring(7);
		try {
			UserDetails user = userDetailsService.loadUserByUsername(jwtUtil.extractUsername(token));
			
			if (jwtUtil.validateToken(token, user)) {
				if(log.isInfoEnabled()){
					log.info("Validating....");
				}
				
				return new ResponseEntity<>(true, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<MyUser> signUp(@RequestBody MyUser myUser) {
		
		userDetailsService.createUser(myUser);
		if(log.isInfoEnabled()){
			log.info("New User Registered!!!");
		}
		
		 
		return new ResponseEntity<MyUser>(HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getIncome/{username}")
	 public ResponseEntity<IncomeDetails> getIncome(@PathVariable String username){
		if(log.isInfoEnabled()){
			log.info("Inside getIncome method");
		}
				return new ResponseEntity<>(userDetailsService.getIncome(username),HttpStatus.OK);
		
	}
	
	
}
