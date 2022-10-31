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
public class SeverityResponseTest {
	
	@Mock
	SeverityResponse severityResponse;

	@Before
	public void setUp() {
		severityResponse=new SeverityResponse();
		severityResponse.setExpenseStatus("RED");
		severityResponse.setSalary(50000);
		severityResponse.setSpent(30000);
		severityResponse.setTargetSaving(35000);
		severityResponse.setBalance(20000);
	}

	@Test
	public void severityDetailsAllConstructorTest() {
		SeverityResponse severity = new SeverityResponse("RED",50000,30000,35000,20000);
		assertEquals("RED", severity.getExpenseStatus());
	}
	
	@Test
	public void statusTest() {
		assertEquals("RED", severityResponse.getExpenseStatus());
	}

	@Test
	public void salaryTest() {
		assertEquals(50000, severityResponse.getSalary());
	}
	
	@Test
	public void spentTest() {
		assertEquals(30000, severityResponse.getSpent());
	}
	
	@Test
	public void targetTest() {
		assertEquals(35000, severityResponse.getTargetSaving());
	}
	
	@Test
	public void balanceTest() {
		assertEquals(20000, severityResponse.getBalance());
	}

	@Test
	public void toStringTest() {
		String string = severityResponse.toString();
		assertEquals(string, severityResponse.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = severityResponse.equals(severityResponse);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = severityResponse.hashCode();
		assertEquals(hashCode, severityResponse.hashCode());
	}
	
	@Test
	public void testGetter() {
		assertEquals("RED", severityResponse.getExpenseStatus());
		assertEquals(50000, severityResponse.getSalary());
		assertEquals(30000, severityResponse.getSpent());
		assertEquals(35000, severityResponse.getTargetSaving());
		assertEquals(20000, severityResponse.getBalance());
		
	}

	@Test
	public void testSetter() {
		severityResponse.setExpenseStatus("GREEN");
		severityResponse.setSalary(50000);
		severityResponse.setSpent(20000);
		severityResponse.setTargetSaving(20000);
		severityResponse.setBalance(30000);
		
		assertEquals("GREEN", severityResponse.getExpenseStatus());
		assertEquals(50000, severityResponse.getSalary());
		assertEquals(20000, severityResponse.getSpent());
		assertEquals(20000, severityResponse.getTargetSaving());
		assertEquals(30000, severityResponse.getBalance());
	}

}
