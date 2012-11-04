package com.BudgetBoss.main;

public class InputValidator {
		
	public String isEntryYOrN(String toTest){
		boolean inputIsValid;
		inputIsValid = yOrNCheck(toTest);		
		if (inputIsValid)
			return toTest.toLowerCase();
		else{
			return "Invalid entry. Try again! (y/n)";
		}
	}
		
	private boolean yOrNCheck(String toCheck){
		if(toCheck.equals("y") || toCheck.equals("Y"))
			return true;
		else if(toCheck.equals("n") || toCheck.equals("N"))
			return true;
		else
			return false;
	}
}