package com.cognizant.expense.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.expense.model.ExpenseDetails;
import com.cognizant.expense.repo.ExpenseDetailsRepo;

@Service
public class ExpenseServiceImpl {
	
	
	@Autowired
	private ExpenseDetailsRepo expenseRepo;

	
	public ResponseEntity<String> createExpense(ExpenseDetails expense) {
			
		expenseRepo.save(expense);
		return new ResponseEntity<String>("Expense Added",HttpStatus.OK);
			
		}


	public List<ExpenseDetails> getExpenses(String username) {
		// TODO Auto-generated method stub
		List<ExpenseDetails> expenses =new ArrayList<>();
		expenses=expenseRepo.findAllByUserName(username);
		return expenses;
	}


	public ResponseEntity<String> deleteExpenses(String username) {
		// TODO Auto-generated method stub
		
		expenseRepo.deleteExpensesByUserName(username);
		return new ResponseEntity<String>("Expenses Re-setted",HttpStatus.OK);
	}


	

	

}
