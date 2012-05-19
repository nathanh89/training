package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
		listener.listenForInput(this);
		}
	}
	


