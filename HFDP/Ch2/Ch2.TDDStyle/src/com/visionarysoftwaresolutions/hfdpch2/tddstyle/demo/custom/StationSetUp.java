package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import com.visionarysoftwaresolutions.hfdpch2.tddstyle.observers.Display;

public class StationSetUp {
	
	public ArrayList<String> displaysToShow = new ArrayList<String>();
	
	public StationSetUp(){
	}

	public void promptForDisplays() {
		scanForDisplays();
		printInstalledList();
	}
	
	public void scanForDisplays(){
		String registryPath = "/home/nathan/Documents/training/HFDP/Ch2/Ch2.TDDStyle/test/DisplayInstallRegistry"; 
		File installFolder = new File(registryPath);
		String[] installedList = installFolder.list();
		for(int i=0; i<installedList.length; i++){
			String display = installedList[i];
			displaysToShow.add(display);
			}
		}
			
	public void printInstalledList(){
		Collections.sort(displaysToShow);
		int displayIndex = 0;
		for(String display : displaysToShow){
			formatCheck(displayIndex, display);
			displayIndex++;
		}
		System.out.println("Please input your selection (#), up to 4 displays:");
	}
	
	public void formatCheck(int displayIndex, String display){
		if(displayIndex == 0){
			System.out.println("[INSTALLED DISPLAYS]\n");
			System.out.println(1 + ") " + display + "\n");
		}
		if (displayIndex > 0){
			int displayedListNumber = displayIndex +1;
			System.out.println(displayedListNumber + ") " + display + "\n");
		}
	}
}


