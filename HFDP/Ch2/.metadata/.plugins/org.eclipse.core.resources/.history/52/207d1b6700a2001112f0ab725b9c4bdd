package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

public class InputValidator {
	
	public int validateInput(StationSetUp setUp, String toCheck){
		int intInput;
		intInput = isInteger(toCheck);
		if(isInRange(intInput)){
			return intInput;
		}
		else{
			return 0;
		}
	}
	
	public int isInteger(String toCheck){
		int input;
		try{
			Integer.parseInt(toCheck);
		}catch(NumberFormatException exception){
			failedReturn();
		}
		input = Integer.parseInt(toCheck);
		return input;
	}
	
	public boolean isInRange(int input){
		if(input > 0 && input < 5){
			return true;
		}
		else{
			System.out.println("That's not a valid selection.");
			return false;
		}
	}
	
	public int failedReturn(){
		return 0;
	}
}