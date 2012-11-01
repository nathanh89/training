package com.BudgetBoss.main;

public class InputValidator {
	
	public boolean validateInput(String toCheck){
		if(toCheck.equals("y") || toCheck.equals("Y"))
			return true;
		else if(toCheck.equals("n") || toCheck.equals("N"))
			return true;
		else
			return false;
	}
}