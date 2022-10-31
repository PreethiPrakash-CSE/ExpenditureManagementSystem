package com.cognizant.authorization.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Test - MyUser class
 */
public class MyUserTest {

	@Mock
	MyUser myUser;

	@Before
	public void setUp() {
		myUser = new MyUser();
		myUser.setId(1);
		myUser.setUserName("vishal");
		myUser.setPassword("abc");
		myUser.setEmail("vishal@gmail.com");
		myUser.setSalary(20000);
	}

	@Test
	public void userCredentialsAllConstructorTest() {
		MyUser user = new MyUser(1, "vishal", "abc","vishal@gmail.com",20000);
		assertEquals("vishal", user.getUserName());
	}

	@Test
	public void userIdTest() {
		assertEquals(1, myUser.getId());
	}

	@Test
	public void userNameTest() {
		assertEquals("vishal", myUser.getUserName());
	}

	@Test
	public void passwordTest() {
		assertEquals("abc", myUser.getPassword());
	}
	@Test
	public void emailTest() {
		assertEquals("vishal@gmail.com", myUser.getEmail());
	}
	@Test
	public void salaryTest() {
		assertEquals(20000, myUser.getSalary());
	}

	@Test
	public void toStringTest() {
		String string = myUser.toString();
		assertEquals(string, myUser.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = myUser.equals(myUser);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = myUser.hashCode();
		assertEquals(hashCode, myUser.hashCode());
	}

}
