package com.BudgetBoss.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompter {
	
	static String budgetName;
	
	public Budget initialPrompt(String userInput){
			if (userInput.equals("y")){
			System.out.println("Let's make a budget! What should we call it?");
			BufferedReader budgetNameInput = new BufferedReader(new InputStreamReader(System.in));
			try {
				budgetName = budgetNameInput.readLine();
			} catch (IOException e) {
				System.out.println("You messed up. Un-Bosslike.");
			}
			System.out.println("Creating new Budget " + budgetName + "...");
			Budget currentBudget = new Budget(budgetName);
			return currentBudget;
			}
		else if(userInput.equals("n")){
			System.out.println("No Budget? Ok then. Adios, amigo");
			return null;
		}
		else{
			System.out.println(userInput);
			InputListener listener = new InputListener();
			userInput = listener.listenForInput();
			initialPrompt(userInput);		
			return null;
			}
	}	

}
