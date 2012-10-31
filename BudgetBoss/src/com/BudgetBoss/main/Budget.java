package com.BudgetBoss.main;

public class Budget {
	
	String name;
	
	public Budget(String name){
		setName(name);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

}
