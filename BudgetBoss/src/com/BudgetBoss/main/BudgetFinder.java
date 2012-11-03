package com.BudgetBoss.main;

import java.io.*;
import java.util.*;

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
		List<String> budgetPaths= new ArrayList<String>();
		String delimiter = "[/]";
		
		for(int i = 0; i < foundBudgets.length; i++)
			budgetPaths.add(foundBudgets[i].toString());
		
		for(int i = 0; i < budgetPaths.size(); i++){
			String pathName = budgetPaths.get(i);
			String[] splitPathName = pathName.split(delimiter);
			String fileName = splitPathName[splitPathName.length - 1];
			System.out.println(fileName);
			}
		}
	}
