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
	
	public static void main(String args[]){
		boolean inputIsValid;
		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
		System.out.println("Would you like to create a new Budget? (y/n)");
		setUpListener();
		inputIsValid = listener.listenForInput();
		if (inputIsValid){
			System.out.println("Let's make a budget! What should we call it?");
			BufferedReader budgetNameInput = new BufferedReader(new InputStreamReader(System.in));
			try {
				budgetName = budgetNameInput.readLine();
			} catch (IOException e) {
				System.out.println("You fucked up. Un-Bosslike.");
			}
			System.out.println("Creating new Budget " + budgetName + "...");
			currentBudget = new Budget(budgetName);
		}
		else
			System.out.println("No Budget? Ok then. Adios, amigo");
	}

}
