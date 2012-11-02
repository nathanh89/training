package com.BudgetBoss.main;

public class BudgetBoss {
	
	public static Budget currentBudget;
	static InputListener listener;
	static String budgetName;
	static Prompter prompter = new Prompter();
	
	public void setCurrentBudget(String name){
		currentBudget = new Budget(name);
	}
	
	public Budget getCurrentBudget(){
		return currentBudget;
	}
	
	public String currentBudgetID(){
		return currentBudget.getName();
	}
	
	public static void main(String args[]){
		String userInput;
		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
		System.out.println("Would you like to create a new Budget? (y/n)");
		listener = InputListener.setUpListener();
		userInput = listener.listenForInput();
		prompter.initialPrompt(userInput);
	}
}
