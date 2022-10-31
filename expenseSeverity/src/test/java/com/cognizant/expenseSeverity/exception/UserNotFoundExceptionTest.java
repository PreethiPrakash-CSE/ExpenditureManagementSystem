package com.cognizant.expenseSeverity.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test - UserNotFoundException class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserNotFoundExceptionTest {

	@Mock
	InvalidChoiceException invalidChoiceException;

	@Test
	public void testOneArgConstructor() {
		InvalidChoiceException invalidException = new InvalidChoiceException("Invalid choice");
		assertEquals("Invalid choice", invalidException.getMessage());
	}

}
