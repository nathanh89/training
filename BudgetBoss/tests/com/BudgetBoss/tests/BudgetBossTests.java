package com.BudgetBoss.tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.BudgetBoss.main.*;


public class BudgetBossTests {
	
	BudgetBoss testCase;
	Budget testBudget;
	
	@Before
	public void setup(){
		testCase = new BudgetBoss();
	}

	@Test
	public void budgetGenerationTest() {
		//Given: An instance of BudgetBoss
		//When: A new Budget is requested
		testCase.requestBudget("testBudget");
		//Then: BudgetBoss can create a Budget
		assertEquals(testCase.currentBudgetID(), "testBudget");
	}
	
	@Test
	public void budgetHasStartEndDate(){
		//Given: An instance of BudgetBoss
	    //When: A a new Budget is created
		testCase.requestBudget("testBudget");
	    //Then: It will have start and end dates
		assertEquals(testCase.currentBudget.getStartDate(), "01/01/2012");
		assertEquals(testCase.currentBudget.getEndDate(), "12/31/2012");
	}
	
	@Test
	public void setStartEndDate(){
		//Given: An instance of BudgetBoss
		//When: A new Budget it created
		testCase.requestBudget("testBudget");
		//And: Different dates other than the default are desired
		testCase.currentBudget.setStartDate("11/01/2012");
		testCase.currentBudget.setEndDate("11/15/2012");
		//Then: The new dates will be set correctly
		assertEquals(testCase.currentBudget.getStartDate(), "11/01/2012");
		assertEquals(testCase.currentBudget.getEndDate(), "11/15/2012");

	}
}
