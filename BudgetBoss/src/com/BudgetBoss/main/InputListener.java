package com.BudgetBoss.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputListener {
	
	public InputValidator validator;
	private String desiredInput;
	
	public boolean listenForInput(){
			BufferedReader listener = new BufferedReader(new InputStreamReader(System.in));
			try {
				desiredInput = listener.readLine();
			} catch (IOException e) {
				System.out.println("You fucked up. Un-Bosslike.");
			}
			boolean isInputValid = testInput(desiredInput);
			return isInputValid;
	}
		
	private boolean testInput(String toTest){
		validator = new InputValidator();
		boolean result;
		result = validator.validateInput(desiredInput);
		return result;
	}
}