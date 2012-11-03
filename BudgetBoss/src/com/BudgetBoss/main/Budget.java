package com.BudgetBoss.main;

import java.io.Serializable;

public class Budget implements Serializable{
	
	private static final long serialVersionUID = -8611741910364436624L;
	
	String name;
	String startDate;
	String endDate;
	
	public Budget(String name){
		setName(name);
		startDate = "01/01/2012";
		endDate = "12/31/2012";
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;		
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String toString(Budget budgetString){
		return budgetString.getName();
	}

}
