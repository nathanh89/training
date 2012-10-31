package com.BudgetBoss.tests;
import static org.junit.Assert.*;
import org.junit.Test;
import com.BudgetBoss.main.*;


public class BudgetBossTests {

	@Test
	public void budgetGenerationTest() {
		//Given: An instance of BudgetBoss
		BudgetBoss testCase = new BudgetBoss();
		//When: A new Budget is requested
		testCase.requestBudget("testBudget");
		//Then: BudgetBoss can create a Budget
		assertEquals(testCase.currentBudgetID(), "testBudget");
	}

}
