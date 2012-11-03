package com.visionarysoftwaresolutions.ordering;

import java.util.ArrayList;
import java.util.List;


public class StorageUnit implements Storable {
	private boolean doorOpen = false;
	private int capacity;
	private List<Orderable> stored;
	private StockAnalyst analyst;
	
	public StorageUnit(int capacity) {
    	setCapacity(capacity);
    	stored = new ArrayList<Orderable>();
    	analyst = new StockAnalyst(this);
    }

	@Override
	public boolean isDoorOpen() {
	    return doorOpen;
	}

	@Override
	public void operateDoor() {
	    setDoorOpen(!doorOpen);
	}

	@Override
	public void setDoorOpen(boolean b) {
	    doorOpen = b;
	}
	
	public List<Orderable> getStoredItems(){
		return stored;
	}
	

	public int getStoredCount() {
	    return stored.size();
	}

	@Override
	public void add(Orderable item) {
		stored.add(item);
	}

	@Override
	public void remove(Orderable item){
		stored.remove(item);
	}
	
	@Override
	public int getCapacity() {
	    return capacity;
	}

	@Override
	public void setCapacity(int desired) {
		capacity = desired;
	}

	@Override
	public int getPercentFull() {
	       double percent;
	       int numberStored = getStoredCount();
	       percent = (double) numberStored / (double) getCapacity();
	       percent *= 100;
	       return (int) percent;
	   }

	@Override
	public void checkNotMoreThanCapacity(int desired) throws RuntimeException {
		if(desired + getStoredCount() > getCapacity()){
	        throw new RuntimeException("That's more bottles than the cooler can hold!");
	    }
	}
	
	public void updatePriceTag(String name, double newPrice){
		analyst.updatePriceTag(name, newPrice);
	}
	
	public double getTotalStockValue(){
		return analyst.getTotalStockValue();
	}
	
	public double getStockValueByProduct(String name){
		return analyst.getStockValueByProduct(name);
	}
	
	public double getPriceForProduct(String name){
		return analyst.getPriceForProduct(name);
	}
	
	public int getCountForProduct(String name){
		return analyst.getCountForProduct(name);
	}
}