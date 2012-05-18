package com.visionarysoftwaresolutions.hfdpch2.bookstyle.lifechanger;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class SwingObserverExample {
	
	JFrame frame;
	
	public static void main(String args[]){
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}
	
	public void go(){
		frame = new JFrame();
		JButton button = new JButton("Should I do it");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
	}
	
	class AngelListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("Don't do it, jackass!");
		}
	}
	
	class DevilListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("Go on and do it, jackass!");
			
		}
	}

}
