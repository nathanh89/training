package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import java.util.ArrayList;

public class StationSetUp {
	
	public ArrayList<Integer> displaysInput = new ArrayList<Integer>();
	public InputListener listener = new InputListener();
	public DisplayGetter displayGetter = new DisplayGetter();
	public ArrayList<String> installedDisplays = new ArrayList<String>();
	
	public StationSetUp(){
	}

	public void promptForDisplays() {
		displayGetter.scanForDisplays(this);
		displayGetter.printInstalledList(this);
		displaysInput = listener.listenForInput();
		}
	
	public ArrayList<Integer> getDesiredDisplays(){
		return displaysInput;
	}
}