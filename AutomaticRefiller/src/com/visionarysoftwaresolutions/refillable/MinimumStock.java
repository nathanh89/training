package com.visionarysoftwaresolutions.refillable;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MinimumStock {
	private HashMap<String,Integer> desiredStockLevels = new LinkedHashMap<String,Integer>();
	
	MinimumStock(String beverageName, int beverageQuantity){
		update(beverageName, beverageQuantity);
	}
	
	public MinimumStock() { }

	public void update(String beverageName, int beverageQuantity){
		desiredStockLevels.put(beverageName, beverageQuantity);
	}

	public int getThreshold(String beverageName) {
		return (desiredStockLevels.containsKey(beverageName)) ? desiredStockLevels.get(beverageName) : 0;
	}
	
}
