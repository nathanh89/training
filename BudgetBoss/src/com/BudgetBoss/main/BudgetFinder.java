package com.BudgetBoss.main;

import java.io.*;

public class BudgetFinder {
	
	public File[] findBudgets(String directoryToSearch){
		File foundBudget = new File(directoryToSearch);
		return foundBudget.listFiles(new FilenameFilter(){
			public boolean accept(File foundBudget, String filename){
				return filename.endsWith(".bgt");
			}
		});
	}
	
	public void printFoundBudgets(File[] foundBudgets){
		for(int i = 0; i < foundBudgets.length; i++){
			System.out.println(foundBudgets[i]);
		}
	}
}

