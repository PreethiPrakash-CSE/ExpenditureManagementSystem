package com.cognizant.expenseSeverity.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ExpenseDetailsTest {
	
	@Mock
	ExpenseDetails expenseDetails;

	@Before
	public void setUp() {
		expenseDetails=new ExpenseDetails();
		expenseDetails.setId(1);
		expenseDetails.setUserName("vishal");
		expenseDetails.setDescription("House Rent");
		expenseDetails.setCategory("debit");
		expenseDetails.setAmount(20000);
	}

	@Test
	public void expenseDetailsAllConstructorTest() {
		ExpenseDetails expense = new ExpenseDetails(1,"vishal","House Rent","debit", 20000);
		assertEquals("vishal", expense.getUserName());
	}
	
	@Test
	public void idTest() {
		assertEquals(1, expenseDetails.getId());
	}

	@Test
	public void userNameTest() {
		assertEquals("vishal", expenseDetails.getUserName());
	}
	
	@Test
	public void descriptionTest() {
		assertEquals("House Rent", expenseDetails.getDescription());
	}
	
	@Test
	public void categoryTest() {
		assertEquals("debit", expenseDetails.getCategory());
	}
	
	@Test
	public void amountTest() {
		assertEquals(20000, expenseDetails.getAmount());
	}

	@Test
	public void toStringTest() {
		String string = expenseDetails.toString();
		assertEquals(string, expenseDetails.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = expenseDetails.equals(expenseDetails);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = expenseDetails.hashCode();
		assertEquals(hashCode, expenseDetails.hashCode());
	}
	
	@Test
	public void testGetter() {
		assertEquals(1, expenseDetails.getId());
		assertEquals("vishal", expenseDetails.getUserName());
		assertEquals("House Rent", expenseDetails.getDescription());
		assertEquals("debit", expenseDetails.getCategory());
		assertEquals(20000, expenseDetails.getAmount());
		
	}

	@Test
	public void testSetter() {
		expenseDetails.setId(2);
		expenseDetails.setUserName("preethi");
		expenseDetails.setDescription("College Scholarship");
		expenseDetails.setCategory("credit");
		expenseDetails.setAmount(30000);
		
		assertEquals(2, expenseDetails.getId());
		assertEquals("preethi", expenseDetails.getUserName());
		assertEquals("College Scholarship", expenseDetails.getDescription());
		assertEquals("credit", expenseDetails.getCategory());
		assertEquals(30000, expenseDetails.getAmount());
	}

}
