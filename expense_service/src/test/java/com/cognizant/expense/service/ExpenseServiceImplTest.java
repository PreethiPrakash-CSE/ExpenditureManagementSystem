package com.cognizant.expense.service;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.expense.model.ExpenseDetails;
import com.cognizant.expense.repo.ExpenseDetailsRepo;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ExpenseServiceImplTest {
	
	@Mock
	ExpenseDetailsRepo repo;
	
	@InjectMocks
	ExpenseServiceImpl service;
	
	private ExpenseDetails expense;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		expense=new ExpenseDetails();
		expense.setUserName("vishal");
		expense.setDescription("House Rent");
		expense.setCategory("debit");
		expense.setAmount(25000);
		
		
		
		//when(repo.findById(1001)).thenReturn(Optional.ofNullable(customerLoan));
	}
	
	@Test
	public void TestSaveExpenses() throws Exception{
		
		ResponseEntity<String> response=service.createExpense(expense);
		assertEquals("Expense Added",response.getBody());
		
	}
	
	@Test
	public void TestDeleteExpenses() throws Exception{
		service.deleteExpenses("vishal");
	}

	@Test
	public void TestGetExpenses() throws Exception{
		List<ExpenseDetails> expenses =new ArrayList<>();
		expenses=service.getExpenses("vishal");
		assertEquals(expenses.toString(),service.getExpenses("vishal").toString());
	}
}
