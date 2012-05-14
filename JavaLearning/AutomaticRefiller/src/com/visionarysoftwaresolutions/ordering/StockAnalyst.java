package com.visionarysoftwaresolutions.ordering;

public class StockAnalyst {
	private StorageUnit toAnalyze;
	
	public StockAnalyst(StorageUnit unit){
		toAnalyze = unit;
	}
	
	public void updatePriceTag(String name, double newPrice) {
	    for(Orderable ordered : toAnalyze.getStoredItems()){
	        if(ordered.getName() == name){
	            ordered.setPrice(newPrice);
	        }
	    }
	}

	public double getTotalStockValue() {
	    double totalStockValue = 0.00;
	    for(Orderable ordered: toAnalyze.getStoredItems()){
	        totalStockValue += ordered.getPrice();
	    }
	    return totalStockValue;
	}

	public double getStockValueByProduct(String name) {
	    double stockValueByType = 0.00;
	    for(Orderable ordered: toAnalyze.getStoredItems()){
	        if(name == ordered.getName()){
	            stockValueByType += ordered.getPrice();
	        }
	    }
	    return stockValueByType;
	}

	public double getPriceForProduct(String name) {
		double result = 0.0;
		for(Orderable ordered : toAnalyze.getStoredItems()){
		if(name == ordered.getName()){
	            result = ordered.getPrice();
	        }
	    }
	    return result;
	}

	public int getCountForProduct(String name) {
	    int beverageCount = 0;
	    for(Orderable target : toAnalyze.getStoredItems()){
	        beverageCount += (target.getName().equalsIgnoreCase(name)) ? 1 : 0;
	    }
	    return beverageCount;
	}
}
