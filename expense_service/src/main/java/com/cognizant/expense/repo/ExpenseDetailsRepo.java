package com.cognizant.expense.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.expense.model.ExpenseDetails;

@Transactional
@Repository
public interface ExpenseDetailsRepo extends JpaRepository<ExpenseDetails,Integer>{

	List<ExpenseDetails> findAllByUserName(String username);
	void deleteExpensesByUserName(String username);

}

