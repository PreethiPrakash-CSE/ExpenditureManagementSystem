package com.cognizant.expenseSeverity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SeverityResponse {
	private String expenseStatus;
	private int salary;
	private int spent;
	private int targetSaving;
	private int Balance;

}
