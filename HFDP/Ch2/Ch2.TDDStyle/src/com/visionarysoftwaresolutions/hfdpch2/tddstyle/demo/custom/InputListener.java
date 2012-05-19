package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputListener {
		
	public void listenForInput(){
		BufferedReader listener = new BufferedReader(new InputStreamReader(System.in));
		try {
			String selectedDisplay = listener.readLine();
			registerSelection(selectedDisplay);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void registerSelection(String selectedDisplay){
		int displayNumber = Integer.parseInt(selectedDisplay);
		
	}

}
