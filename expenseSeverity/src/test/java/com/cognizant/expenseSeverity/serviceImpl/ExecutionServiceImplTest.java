package com.cognizant.expenseSeverity.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.expenseSeverity.feign.AuthClient;
import com.cognizant.expenseSeverity.feign.ExpenseServiceClient;
import com.cognizant.expenseSeverity.feign.TargetBenchmarkClient;
import com.cognizant.expenseSeverity.model.ExpenseDetails;
import com.cognizant.expenseSeverity.model.IncomeDetails;
import com.cognizant.expenseSeverity.model.SeverityResponse;
import com.cognizant.expenseSeverity.model.TargetDetails;

@RunWith(MockitoJUnitRunner.class)
public class ExecutionServiceImplTest {
	
	//private final static Logger log = LoggerFactory.getLogger(ExecutionServiceImpl.class);

	@Mock
	ExpenseServiceClient expenseClient;
	
	@Mock
	TargetBenchmarkClient targetClient;
	
	@Mock
	AuthClient authClient;
	
	@InjectMocks
	ExecutionServiceImpl executionServiceImpl;
	
	private static TargetDetails targetDetail;
	
	private IncomeDetails incomeDetails;
	
	private SeverityResponse severityResponse;
	
	private List<ExpenseDetails> expenses;
	
	
	
	@Before
	public void setUp() throws Exception
	{
		expenses =new ArrayList<>();
		ExpenseDetails exp1=new ExpenseDetails();
		exp1.setId(1);
		exp1.setUserName("preethi");
		exp1.setDescription("House Rent");
		exp1.setCategory("debit");
		exp1.setAmount(12000);
		expenses.add(exp1);
		expenses.add(new ExpenseDetails(1,"preethi","House Rent","debit",20000));
		expenses.add(new ExpenseDetails(2,"preethi","scholarship","credit",10000));
		expenses.add(new ExpenseDetails(3,"preethi","Food","debit",800));
		
		targetDetail=new TargetDetails(1,"preethi",25000);
		incomeDetails = new IncomeDetails("preethi",50000);
		
		when(expenseClient.getExpenses("", "preethi")).thenReturn(expenses);
		when(targetClient.getTarget("", "preethi")).thenReturn(targetDetail);
		when(authClient.getIncome("preethi")).thenReturn(incomeDetails);
		

		
	}


	@Test
	public void testExpenseSeverityStatusGreen() throws Exception
	{	
		severityResponse = executionServiceImpl.expenseSeverityStatus("", "preethi");
		assertEquals(severityResponse.toString(),
				executionServiceImpl.expenseSeverityStatus("", "preethi").toString());
		
	}
	
	@Test
	public void testExpenseSeverityStatusRed() throws Exception
	{	
		//severityResponse= new SeverityResponse();
		targetDetail.setAmount(50000);
		severityResponse = executionServiceImpl.expenseSeverityStatus("", "preethi");
		assertEquals(severityResponse.toString(),
				executionServiceImpl.expenseSeverityStatus("", "preethi").toString());
		
	}
}
