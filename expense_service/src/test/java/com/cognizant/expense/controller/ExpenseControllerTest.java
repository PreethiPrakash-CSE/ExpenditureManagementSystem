package com.cognizant.expense.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.expense.feign.AuthClient;
import com.cognizant.expense.model.ExpenseDetails;
import com.cognizant.expense.repo.ExpenseDetailsRepo;
import com.cognizant.expense.service.ExpenseServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExpenseControllerTest {
	
	@Mock
	ExpenseDetailsRepo repo;
	
	@Mock
	ExpenseServiceImpl service;
	
	@Mock
	AuthClient authClient;
	
	@InjectMocks
	ExpenseController controller;
	
	
	
	private ExpenseDetails expense;
	
	private List<ExpenseDetails> expenseList;
	
	@Before
	public void setUp() throws Exception {
		expense =new ExpenseDetails();
		expense.setUserName("vishal");
		expense.setDescription("House Rent");
		expense.setCategory("debit");
		expense.setAmount(25000);
		
		expenseList=new ArrayList<ExpenseDetails>();
		expenseList.add(expense);
		
		when(authClient.validate("token")).thenReturn(true);
		when(service.createExpense(expense)).thenReturn(new ResponseEntity<String>("Expense Added",HttpStatus.OK));
		when(service.deleteExpenses("vishal")).thenReturn(new ResponseEntity<String>("Expense Re-setted",HttpStatus.OK));
		when(service.getExpenses("vishal")).thenReturn(expenseList);
	}
	
	@Test
	public void testAddExpense() throws Exception {

		ResponseEntity<String> response=controller.addExpense("token", expense);
		assertEquals("Expense Added",response.getBody());
		
	}
	
	@Test
	public void testAddExpenseFail() throws Exception {

		ResponseEntity<?> response=controller.addExpense("token1", expense);
		assertEquals(HttpStatus.FORBIDDEN,response.getStatusCode());
		
	}
	

	@Test
	public void testDeleteExpense() throws Exception {
		ResponseEntity<String> response=controller.deleteExpenses("token", "vishal");
		assertEquals("Expense Re-setted",response.getBody());
		
	}
	
	@Test
	public void testDeleteExpenseFail() throws Exception {

		ResponseEntity<?> response=controller.deleteExpenses("token1", "vishal");
		assertEquals(HttpStatus.FORBIDDEN,response.getStatusCode());
		
	}
	
	@Test
	public void testgetExpense() throws Exception {
		ResponseEntity<List<ExpenseDetails>> response=controller.getExpenses("token", "vishal");
		assertEquals(expenseList.toString(),response.getBody().toString());
		
	}
	
	@Test
	public void testgetExpenseFail() throws Exception {

		ResponseEntity<?> response=controller.getExpenses("token1", "vishal");
		assertEquals(HttpStatus.FORBIDDEN,response.getStatusCode());
		
	}

}
