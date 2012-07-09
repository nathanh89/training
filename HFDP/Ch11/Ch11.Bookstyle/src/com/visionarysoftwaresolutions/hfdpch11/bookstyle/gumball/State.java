package com.visionarysoftwaresolutions.hfdpch11.bookstyle.gumball;

import java.io.*;

public interface State extends Serializable {
 
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}