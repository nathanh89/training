package com.BudgetBoss.main;

public class BudgetBoss {
	
	public Budget currentBudget;
	
	public void requestBudget(String name){
		currentBudget = new Budget(name);
	}
	
	public String currentBudgetID(){
		return currentBudget.getName();
	}

}