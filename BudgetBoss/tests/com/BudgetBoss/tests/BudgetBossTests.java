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
	public void budgetStartEndDateTest(){
		//Given: An instance of BudgetBoss
	    //When: A a new Budget is created
		testCase.requestBudget("testBudget");
	    //Then: It will have start and end dates
		assertEquals(testCase.currentBudget.getStartDate(), "01/01/2012");
		assertEquals(testCase.currentBudget.getEndDate(), "12/31/2012");
	}
}
