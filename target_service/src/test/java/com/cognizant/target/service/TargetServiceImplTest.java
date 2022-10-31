package com.cognizant.target.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.target.model.TargetDetails;
import com.cognizant.target.repo.TargetDetailsRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TargetServiceImplTest {
	
	@Mock
	TargetDetailsRepo repo;
	
	@InjectMocks
	TargetServiceImpl service;
	
	private TargetDetails target;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		target=new TargetDetails();
		target.setUserName("vishal");
		target.setAmount(25000);
		
	}
	
	@Test
	public void TestGetTarget() throws Exception{
		TargetDetails result =new TargetDetails();
		when(repo.findByUserName("vishal")).thenReturn(target);
		when(repo.findAmountByUserName("vishal")).thenReturn(target);
		result=service.getTarget("vishal");
		assertEquals(result.toString(),service.getTarget("vishal").toString());
	}
	
	@Test
	public void TestGetTargetFail() throws Exception{
		TargetDetails result =new TargetDetails();
		when(repo.findByUserName("vishal")).thenReturn(null);
		//when(repo.findAmountByUserName("vishal")).thenReturn(target);
		result=service.getTarget("vishal");
		assertEquals(result.toString(),service.getTarget("vishal").toString());
	}
	
	@Test
	public void TestsetTarget() throws Exception{
		String result;
		when(repo.findByUserName("vishal")).thenReturn(null);
		result=service.setTarget(target);
		assertEquals(result,service.setTarget(target).toString());
	}
	
	@Test
	public void TestsetTargetFail() throws Exception{
		String result;
		when(repo.findByUserName("vishal")).thenReturn(target);
		result=service.setTarget(target);
		assertEquals(result,service.setTarget(target).toString());
	}
	
	@Test
	public void TestupdateTarget() throws Exception{
		String result;
		when(repo.findByUserName("vishal")).thenReturn(target);
		when(repo.updateTargetAmount(target.getAmount(),target.getUserName())).thenReturn(1);
		result=service.updateTarget(target);
		assertEquals(result,service.updateTarget(target).toString());
	}
	
	@Test
	public void TestupdateTargetFail() throws Exception{
		String result;
		when(repo.findByUserName("vishal")).thenReturn(null);
		when(repo.updateTargetAmount(target.getAmount(),target.getUserName())).thenReturn(0);
		result=service.updateTarget(target);
		assertEquals(result,service.updateTarget(target).toString());
	}
}
