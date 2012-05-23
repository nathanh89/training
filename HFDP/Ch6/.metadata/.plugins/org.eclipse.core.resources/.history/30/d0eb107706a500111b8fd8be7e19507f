package com.visionarysoftwaresolutions.hfdpch6.bookstyle.remotecontrol;

public class HottubOffCommand implements Command {
	Hottub hottub;

	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.bubblesOff();
		hottub.cool();
		hottub.off();
	}
	
	public void undo(){
		hottub.on();
		hottub.heat();
		hottub.bubblesOn();
	}
}
