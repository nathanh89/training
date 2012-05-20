package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputListener {
	
	public InputValidator validator;
	private String desiredInput;
	private int validInputCount = 0;
	private int validatedInput;
	public ArrayList<Integer> testedInputs = new ArrayList<Integer>();
	
	public ArrayList<Integer> listenForInput(){
		while(validInputCount < 4){
			int input;
			BufferedReader listener = new BufferedReader(new InputStreamReader(System.in));
			try {
				desiredInput = listener.readLine();
			} catch (IOException e) {
				System.out.println("You fucked up.");
			}
			if(desiredInput.equals("d"))
				validInputCount = 4;
			else{ 
				input = testInput(desiredInput);
				if(input > 0)
					testedInputs.add(input);
			}
		}
		return testedInputs;
	}
	
	public String getDesiredInput(){
		return desiredInput;
	}
	
	public int getValidatedInput(){
		return validatedInput;
	}
	
	private int testInput(String toTest){
		validator = new InputValidator();
		validatedInput = validator.validateInput(desiredInput);
		if(validatedInput > 0)
			validInputCount++;
		return validatedInput;
	}
//
//	public void registerSelection(String selectedDisplay, StationSetUp setUp){
//			Display display;
//			display = InputReference.createDisplayByInput(Integer.parseInt(selectedDisplay));
//			if(notAlreadyAdded(display, setUp)){
//				setUp.displaysToAdd.add(display);
//				String classSelected = display.getCurrentDisplay().getClass().getSimpleName();
//				System.out.println(classSelected + " display added.");
//				displaysAdded++;
//			}
//		setUp.listener.listenForInput(setUp);
//	}
//	
//	private boolean notAlreadyAdded(Display display, StationSetUp setUp){
//		for(Display displayInList : setUp.displaysToAdd){
//			String desiredDisplay = display.getCurrentDisplay().getClass().getSimpleName();
//			String currentDisplay = displayInList.getCurrentDisplay().getClass().getSimpleName();
//			if(desiredDisplay.equals(currentDisplay)){
//				System.out.println("You've already picked that display!");
//				return false;
//			}
//		}
//		return true;
//	}
}