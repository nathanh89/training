package com.BudgetBoss.tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.BudgetBoss.main.*;


public class BudgetBossTests {
	
	BudgetBoss testCase;
	
	@Before
	public void setup(){
		testCase = new BudgetBoss();
	}

	@Test
	public void budgetGenerationTest() {
		//Given: An instance of BudgetBoss
		//When: A new Budget is requested
		//Then: BudgetBoss can create a Budget
		testCase.setCurrentBudget("testBudget");
		assertEquals(testCase.currentBudgetID(), "testBudget");
	}
	
	@Test
	public void budgetHasStartEndDate(){
		//Given: An instance of BudgetBoss
	    //When: A a new Budget is created
		testCase.setCurrentBudget("testBudget");
	    //Then: It will have start and end dates
		assertEquals(testCase.getCurrentBudget().getStartDate(), "01/01/2012");
		assertEquals(testCase.getCurrentBudget().getEndDate(), "12/31/2012");
	}
	
	@Test
	public void setStartEndDate(){
		//Given: An instance of BudgetBoss
		//When: A new Budget it created
		testCase.setCurrentBudget("testBudget");
		//And: Different dates other than the default are desired
		testCase.getCurrentBudget().setStartDate("11/01/2012");
		testCase.getCurrentBudget().setEndDate("11/15/2012");
		//Then: The new dates will be set correctly
		assertEquals(testCase.getCurrentBudget().getStartDate(), "11/01/2012");
		assertEquals(testCase.getCurrentBudget().getEndDate(), "11/15/2012");

	}
	
	@Test
	public void currentBudgetNullCheck(){
		//Given an instance of BudgetBoss
		//When no Budget is created or opened
		//Then the variable currentBudget will pass a null check
		assertNull(testCase.getCurrentBudget());
	}
}
