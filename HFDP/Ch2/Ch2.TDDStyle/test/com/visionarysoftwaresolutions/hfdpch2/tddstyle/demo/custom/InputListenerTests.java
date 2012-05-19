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
	
	@Test
	public void testStopListening(){
		//Given: I have an InputListener
		//And: I want it to save the next input as a string, then stop listening
		listener.listenForInput();
		//When: I input something (input anything into the console to test)
		//Then: The listener should stop listening
		//Test has passed if application has terminated
	}
	
	@Test
	public void testValidatorInteraction(){
		//Given I have an InputListener that has a InputValidator
		//And: It is listening for input
		listener.listenForInput();
		//When: I input something into the console (Input 3 to get test to pass)
		//And: I expect the input to be validated
		//Then: The input should be validated
		assertEquals(3, listener.getValidatedInput());
	}
}

