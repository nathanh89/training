package com.BudgetBoss.main;

public class BudgetBoss {
	
	static InputListener listener;
	static Prompter prompter = new Prompter();
	static Budget currentBudget = null;
	static InputValidator validator;
	static BudgetFinder finder = new BudgetFinder();
	
	public static void main(String args[]){
		
		int invalidEntries = 0;
		String validatedInput = "Invalid entry. Try again! (y/n)";

		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
		System.out.println("Is there an existing Budget you want to open? (y/n)");
		
		while (validatedInput.equals("Invalid entry. Try again! (y/n)")){
			listener = new InputListener();
			validator = new InputValidator();
			if(invalidEntries > 0)
				System.out.println(validatedInput);
			String userInput = listener.listenForInput();
			validatedInput = validator.isEntryYOrN(userInput);
			invalidEntries ++;
		}
		
		boolean budgetExists = prompter.openBudgetPrompt(validatedInput, finder);
		
		if(!budgetExists){
			System.out.println("Would you like to create a new Budget? (y/n)");
			validatedInput = ("Invalid entry. Try again! (y/n)");
			invalidEntries = 0;
			while (validatedInput.equals("Invalid entry. Try again! (y/n)")){
				listener = new InputListener();
				validator = new InputValidator();
					if(invalidEntries > 0)
						System.out.println(validatedInput);
					String userInput = listener.listenForInput();
					validatedInput = validator.isEntryYOrN(userInput);
					invalidEntries ++;
			}
			currentBudget = prompter.createBudgetPrompt(validatedInput);
		}
		
		Salvation savior = new Salvation();
		try{	
			savior.saveOnExit(currentBudget.getName(), currentBudget);
		}catch (NullPointerException e){
		System.out.println("No Budget to save!");
		}
	}
}
