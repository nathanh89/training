package com.BudgetBoss.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BudgetBoss {
	
	public static Budget currentBudget;
	static InputListener listener;
	static String budgetName;
	
	public void setCurrentBudget(String name){
		currentBudget = new Budget(name);
	}
	
	public Budget getCurrentBudget(){
		return currentBudget;
	}
	
	public String currentBudgetID(){
		return currentBudget.getName();
	}
	
	static void setUpListener(){
		listener = new InputListener();
	}
	
	private static void initialPrompt(String userInput){
		if (userInput.equals("y")){
			System.out.println("Let's make a budget! What should we call it?");
			BufferedReader budgetNameInput = new BufferedReader(new InputStreamReader(System.in));
			try {
				budgetName = budgetNameInput.readLine();
			} catch (IOException e) {
				System.out.println("You messed up. Un-Bosslike.");
			}
			System.out.println("Creating new Budget " + budgetName + "...");
			currentBudget = new Budget(budgetName);
			}
		else if(userInput.equals("n"))
			System.out.println("No Budget? Ok then. Adios, amigo");
		else{
			System.out.println(userInput);
			setUpListener();
			userInput = listener.listenForInput();
			initialPrompt(userInput);			
			}
	}	
		
	public static void main(String args[]){
		String userInput;
		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
		System.out.println("Would you like to create a new Budget? (y/n)");
		setUpListener();
		userInput = listener.listenForInput();
		initialPrompt(userInput);
	}
}
