package com.visionarysoftwaresolutions.hfdpch2.tddstyle.demo.custom;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InputListenerTests {
	
	public InputListener listener;
	
	@Before
	public void setup(){
		listener = new InputListener();
	}

	@Test
	public void testListenForInput() {
		//Given: I have an InputListener
		//And: I want it to save the next input as a string
		listener.listenForInput();
		//When: I input something (input a 5 into the console to test)
		//Then: That input should be saved in the listener
		assertTrue("5".equals(listener.getDesiredInput()));
	}
	
}

