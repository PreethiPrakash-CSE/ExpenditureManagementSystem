package com.cognizant.target.model;
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
public class TargetDetailsTest {

	@Mock
	TargetDetails targetDetails;

	@Before
	public void setUp() {
		targetDetails=new TargetDetails();
		targetDetails.setId(1);
		targetDetails.setUserName("vishal");
		targetDetails.setAmount(20000);
	}

	@Test
	public void targetDetailsAllConstructorTest() {
		TargetDetails target = new TargetDetails(1,"vishal", 20000);
		assertEquals("vishal", target.getUserName());
	}
	
	@Test
	public void idTest() {
		assertEquals(1, targetDetails.getId());
	}

	@Test
	public void userNameTest() {
		assertEquals("vishal", targetDetails.getUserName());
	}
	
	
	@Test
	public void amountTest() {
		assertEquals(20000, targetDetails.getAmount());
	}

	@Test
	public void toStringTest() {
		String string = targetDetails.toString();
		assertEquals(string, targetDetails.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = targetDetails.equals(targetDetails);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = targetDetails.hashCode();
		assertEquals(hashCode, targetDetails.hashCode());
	}
	
	@Test
	public void testGetter() {
		assertEquals(1, targetDetails.getId());
		assertEquals("vishal", targetDetails.getUserName());
		assertEquals(20000, targetDetails.getAmount());
		
	}

	@Test
	public void testSetter() {
		targetDetails.setId(2);
		targetDetails.setUserName("preethi");
		targetDetails.setAmount(30000);
		
		assertEquals(2, targetDetails.getId());
		assertEquals("preethi", targetDetails.getUserName());
		assertEquals(30000, targetDetails.getAmount());
	}

}
