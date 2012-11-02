package com.BudgetBoss.main;

import java.io.*;

public class Salvation {
	
	public void saveOnExit(String fileName, Budget budget){
			try{
				FileOutputStream autoSave = new FileOutputStream("/home/visionary/Programming/training/BudgetBoss/SavedBudgets/" + fileName + ".bgt");
				ObjectOutputStream saveOutput = new ObjectOutputStream(autoSave);
				saveOutput.writeObject(budget);
				saveOutput.close();
				System.out.println("Budget saved! Adios, amigo.");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

