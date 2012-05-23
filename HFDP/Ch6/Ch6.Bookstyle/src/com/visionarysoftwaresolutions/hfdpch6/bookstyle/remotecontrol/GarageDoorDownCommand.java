package com.visionarysoftwaresolutions.hfdpch6.bookstyle.remotecontrol;

public class GarageDoorDownCommand implements Command {
	GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.up();
	}
	
	public void undo(){
		garageDoor.down();
	}
}
