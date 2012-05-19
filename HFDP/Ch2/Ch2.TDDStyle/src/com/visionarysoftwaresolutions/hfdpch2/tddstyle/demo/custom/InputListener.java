package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import java.util.Scanner;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.Display;

public class InputListener {
	
	public InputValidator validator;
	
	public void listenForInput(StationSetUp setUp){
		Scanner listener = new Scanner(System.in);
		String desiredDisplay = listener.next();
		validator.validateInput(setUp, desiredDisplay);
	}
	
//	public void listenForInput(StationSetUp setUp){
//		if(displaysAdded < 4){
//			System.out.println("\n");
//			Scanner listener = new Scanner(System.in);
//			String selectedDisplay = listener.next();
//			registerSelection(selectedDisplay, setUp);
//		}
//		else if(displaysAdded == 4){
//		System.out.println("Thanks! Setting up the WeatherStation!");
//		}
//	}
//	
//	public void registerSelection(String selectedDisplay, StationSetUp setUp){
//		if(validInputCheck(selectedDisplay, setUp)){
//			Display display;
//			display = InputReference.createDisplayByInput(Integer.parseInt(selectedDisplay));
//			if(notAlreadyAdded(display, setUp)){
//				setUp.displaysToAdd.add(display);
//				String classSelected = display.getCurrentDisplay().getClass().getSimpleName();
//				System.out.println(classSelected + " display added.");
//				displaysAdded++;
//			}
//		}
//		else{
//			System.out.println("That's not one of the numbers!");
//			setUp.listener.listenForInput(setUp);
//		}
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
		
		

