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
public class IncomeDetailsTest {
	
	@Mock
	IncomeDetails incomeDetails;

	@Before
	public void setUp() {
		incomeDetails=new IncomeDetails();
		incomeDetails.setUserName("vishal");
		incomeDetails.setAmount(25000);
	}

	@Test
	public void incomeDetailsAllConstructorTest() {
		IncomeDetails income = new IncomeDetails("vishal", 25000);
		assertEquals("vishal", income.getUserName());
	}

	@Test
	public void userNameTest() {
		assertEquals("vishal", incomeDetails.getUserName());
	}

	@Test
	public void salaryTest() {
		assertEquals(25000, incomeDetails.getAmount());
	}

	@Test
	public void toStringTest() {
		String string = incomeDetails.toString();
		assertEquals(string, incomeDetails.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = incomeDetails.equals(incomeDetails);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = incomeDetails.hashCode();
		assertEquals(hashCode, incomeDetails.hashCode());
	}
	
	@Test
	public void testGetter() {
		assertEquals("vishal", incomeDetails.getUserName());
		assertEquals(25000, incomeDetails.getAmount());
		
	}

	@Test
	public void testSetter() {
		incomeDetails.setUserName("preethi");
		incomeDetails.setAmount(30000);
		assertEquals("preethi", incomeDetails.getUserName());
		assertEquals(30000, incomeDetails.getAmount());
	}

}
