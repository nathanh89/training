package com.BudgetBoss.main;

public class BudgetBoss {
	
	static InputListener listener;
	static Prompter prompter = new Prompter();
	
	public static void main(String args[]){
		Budget currentBudget = null;
		String userInput;
		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
		System.out.println("Would you like to create a new Budget? (y/n)");
		listener = InputListener.setUpListener();
		userInput = listener.listenForInput();
		currentBudget = prompter.initialPrompt(userInput);
		Salvation savior = new Salvation();
		if(!(currentBudget == null))
			savior.saveOnExit(currentBudget.getName(), currentBudget);
	}
}
