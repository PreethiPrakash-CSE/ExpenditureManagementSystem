package com.cognizant.expenseSeverity.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.expenseSeverity.exception.InvalidChoiceException;
import com.cognizant.expenseSeverity.feign.AuthClient;
import com.cognizant.expenseSeverity.feign.ExpenseServiceClient;
import com.cognizant.expenseSeverity.feign.TargetBenchmarkClient;
import com.cognizant.expenseSeverity.model.ExpenseDetails;
import com.cognizant.expenseSeverity.model.IncomeDetails;
import com.cognizant.expenseSeverity.model.SeverityResponse;
import com.cognizant.expenseSeverity.model.TargetDetails;
import com.cognizant.expenseSeverity.service.ExecutionService;

@Service
public class ExecutionServiceImpl implements ExecutionService {

	private final Logger log = LoggerFactory.getLogger(ExecutionServiceImpl.class);

	@Autowired
	private TargetBenchmarkClient targetClient;
	@Autowired
	private AuthClient authClient;
	@Autowired
	private ExpenseServiceClient expenseClient;

	public SeverityResponse expenseSeverityStatus(String token, String username) throws InvalidChoiceException {

		
		if(log.isInfoEnabled()){
			log.info("In ExpenseServerity service");
		}
		
		SeverityResponse severityResponse= new SeverityResponse();
		IncomeDetails incomeDetails=new IncomeDetails();
		List<ExpenseDetails> expenseDetails = this.expenseClient.getExpenses(token,username);
		int spent = expenseDetails.stream().filter(o -> o.getCategory().equals("debit")).mapToInt(o -> o.getAmount()).sum();
		int credit= expenseDetails.stream().filter(o -> o.getCategory().equals("credit")).mapToInt(o -> o.getAmount()).sum();
		log.info("spent amount" + spent);
		
		TargetDetails target=new TargetDetails();
		target=targetClient.getTarget(token, username);
		severityResponse.setTargetSaving(target.getAmount());
		severityResponse.setSpent(spent);
		
//		if(authClient.validate(token))
//		{
			incomeDetails=authClient.getIncome(username);
			int balance=incomeDetails.getAmount()+credit-spent;
			severityResponse.setSalary(incomeDetails.getAmount());
			severityResponse.setBalance(balance);
			if(balance>target.getAmount())
				severityResponse.setExpenseStatus("GREEN");
			else
				severityResponse.setExpenseStatus("RED");
			
			log.info("Income amount" + incomeDetails.toString());
			log.info("Severity response" + severityResponse.toString());
		//}
		
		
		return severityResponse;
	}

}
