package com.visionarysoftwaresolutions.hfdp.ch1.tddstyle.ducks;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;

public class MallardTests {
	
	private Duck mallard;
	
	@Before
	public void setup(){
	    mallard = new MallardDuck();
	}

	@Test
	public void testInheritedSwim() {
		//Given a mallard duck
		//When it swims using the inherited swim method
		String result = mallard.swim();
		//Then it should demonstrate the desired swim behavior
		assertEquals("All ducks float, even decoys!", result);
	}

}
