package com.BudgetBoss.main;

public class BudgetBoss {
	
	static InputListener listener;
	static Prompter prompter = new Prompter();
	static Budget currentBudget = null;
	static InputValidator validator;
	
	public static void main(String args[]){
		
		String validatedInput = "Invalid entry. Try again! New Budget? (y/n)";
		int invalidEntries = 0;
		
		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
		System.out.println("Would you like to create a new Budget? (y/n)");

		while (validatedInput.equals("Invalid entry. Try again! New Budget? (y/n)")){
			listener = new InputListener();
			validator = new InputValidator();
			if(invalidEntries > 0)
				System.out.println(validatedInput);
			String userInput = listener.listenForInput();
			validatedInput = validator.isEntryValid(userInput);
			invalidEntries ++;
		}
		
		currentBudget = prompter.initialPrompt(validatedInput);
		
		Salvation savior = new Salvation();
		try{	
			savior.saveOnExit(currentBudget.getName(), currentBudget);
		}catch (NullPointerException e){
		System.out.println("No Budget to save!");
		}
	}
}
