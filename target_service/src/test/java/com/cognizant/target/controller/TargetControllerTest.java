package com.cognizant.target.controller;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.target.feign.AuthClient;
import com.cognizant.target.model.TargetDetails;
import com.cognizant.target.repo.TargetDetailsRepo;
import com.cognizant.target.service.TargetServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TargetControllerTest {
	
	@Mock
	TargetDetailsRepo repo;
	
	@Mock
	TargetServiceImpl service;
	
	@Mock
	AuthClient authClient;
	
	@InjectMocks
	TargetController controller;
	
	
	
	private TargetDetails target;
	
	@Before
	public void setUp() throws Exception {
		
		target=new TargetDetails();
		target.setUserName("vishal");
		target.setAmount(25000);
		
		when(authClient.validate("token")).thenReturn(true);
		when(service.setTarget(target)).thenReturn("Target is set successfully");
		when(service.getTarget("vishal")).thenReturn(target);
		when(service.updateTarget(target)).thenReturn("Target is updated successfully");
		
	}

	@Test
	public void testAddTarget() throws Exception {

		ResponseEntity<String> response=controller.addTarget("token", target);
		assertEquals("Target is set successfully",response.getBody());
		
	}
	
	@Test
	public void testAddTargetFail() throws Exception {

		ResponseEntity<?> response=controller.addTarget("token1", target);
		assertEquals(HttpStatus.FORBIDDEN,response.getStatusCode());
		
	}
	
	@Test
	public void testGetTarget() throws Exception {

		ResponseEntity<TargetDetails> response=controller.getTarget("token", "vishal");
		assertEquals(target.toString(),response.getBody().toString());
		
	}
	
	@Test
	public void testGetTargetFail() throws Exception {

		ResponseEntity<TargetDetails> response=controller.getTarget("token1", "vishal");
		assertEquals(HttpStatus.FORBIDDEN,response.getStatusCode());
		
	}
	
	@Test
	public void testupdateTarget() throws Exception {

		ResponseEntity<String> response=controller.updateTarget("token", target);
		assertEquals("Target is updated successfully",response.getBody());
		
	}
	
	@Test
	public void testupdateTargetFail() throws Exception {

		ResponseEntity<?> response=controller.updateTarget("token1", target);
		assertEquals(HttpStatus.FORBIDDEN,response.getStatusCode());
		
	}

	
}
