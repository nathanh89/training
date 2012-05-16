package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;

public class MallardTests {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Duck mallard;
	
	@Before
	public void setup(){
	    System.setOut(new PrintStream(outContent));
	    mallard = new MallardDuck();
	}
	
	@After
	public void clearOutContent(){
		System.setOut(null);
	}
	
	@Test
	public void testInheritedSwim() {
		mallard.swim();
		assertEquals("All ducks float, even decoys!", outContent.toString());
	}

}
