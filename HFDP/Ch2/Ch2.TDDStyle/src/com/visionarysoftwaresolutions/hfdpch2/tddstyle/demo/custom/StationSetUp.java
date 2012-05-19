package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import java.util.ArrayList;
import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.Display;

public class StationSetUp {
	
	public ArrayList<String> installedDisplays = new ArrayList<String>();
	public ArrayList<Display> displaysToAdd = new ArrayList<Display>();
	public InputListener listener = new InputListener();
	public DisplayGetter displayGetter = new DisplayGetter();
	
	public StationSetUp(){
	}

	public void promptForDisplays() {
		displayGetter.scanForDisplays(this);
		displayGetter.printInstalledList(this);
		while(displaysToAdd.size() < 4){
			listener.listenForInput(this);
		}
	}
}
	


