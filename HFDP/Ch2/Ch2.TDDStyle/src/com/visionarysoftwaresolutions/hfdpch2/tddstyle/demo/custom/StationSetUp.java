package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import java.util.ArrayList;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.Display;

public class StationSetUp {
	
	ArrayList<Display> displaysToShow;
	
	StationSetUp(){
	}

	public void promptForDisplays() {
		getInstalledDisplays();
		printInstalledList();
	}
	
	private void getInstalledDisplays(){
		//This method, were it real, would look for installed Displays
		//and pass them in as an ArrayList, then iterate through the
		//list and 
	}
	
	private void printInstalledList(){
		
	}

}
