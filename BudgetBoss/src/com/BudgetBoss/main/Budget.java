package com.BudgetBoss.main;

public class Budget {
	
	String name;
	String startDate;
	String endDate;
	
	public Budget(String name){
		setName(name);
		startDate = "01/01/2012";
		endDate = "12/31/2012";
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;		
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
