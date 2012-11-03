package com.BudgetBoss.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.BudgetBoss.main.Budget;

public class BudgetTests {

	@Test
	public void createABudget() {
		//Given: A Budget needs to be created
		//When: User supplied information is provided
		String uIBudgetName = "testBudget";
		Budget testBudget = new Budget(uIBudgetName);
		//Then: A Budget is created with the supplied information
		assertTrue(testBudget.getName().equals(uIBudgetName));
	}
	
	@Test
	public void budgetHasDates(){
		//Given: A Budget needs to be created
		//When: The budget is generated 
		//Then: It will have start and end dates
		Budget testBudget = new Budget("testBudget");
		assertNotNull(testBudget.getStartDate());
		assertNotNull(testBudget.getEndDate());
	}
	
	@Test
	public void setBudgetDates(){
		//Given: A Budget needs to be created
		//When: The Budget is generated
		Budget testBudget = new Budget("testBudget");
		//And: The user wants to modify the start/end dates
		//Then: The dates can be accessed and manipulated
		testBudget.setStartDate("11/01/2012");
		testBudget.setEndDate("11/15/2012");
		assertTrue(testBudget.getStartDate().equals("11/01/2012"));
		assertTrue(testBudget.getEndDate().equals("11/15/2012"));
	}
	
	@Test public void setBudgetName(){
		//Given: A Budget needs to be created
		//When: The budget is generated
		Budget testBudget = new Budget("testBudget");
		//And: The user wants to modify the name
		//Then: The budget name can be accessed and manipulated
		testBudget.setName("dontNeedNoTestBudget");
		assertTrue(testBudget.getName().equals("dontNeedNoTestBudget"));
	}

}
