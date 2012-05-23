package com.visionarysoftwaresolutions.hfdpch6.bookstyle.remotecontrol;

public class HottubOnCommand implements Command {
	Hottub hottub;

	public HottubOnCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.on();
		hottub.heat();
		hottub.bubblesOn();
	}
	
	public void undo(){
		hottub.bubblesOff();
		hottub.cool();
		hottub.off();
	}
}
