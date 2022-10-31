package com.cognizant.authorization.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorization.model.MyUser;
import com.cognizant.authorization.repo.MyUserRepo;


/**
 * Test - UserDetailsServiceImpl
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {

	@Mock
	MyUserRepo repo;

	@InjectMocks
	UserDetailServiceImpl userDetailsService;

	@Test
	public void loadUserByUsernameTest() {

		MyUser user = new MyUser(5, "admin", "1234","admin@gmail.com",25000);
		when(repo.findByUserName("admin")).thenReturn(user);
		UserDetails loadUserByUsername = userDetailsService.loadUserByUsername("admin");
		assertEquals(user.getUserName(), loadUserByUsername.getUsername());
	}

}
