package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

import com.visionarysoftwaresolutions.ordering.Orderable;
import com.visionarysoftwaresolutions.ordering.Orderer;

class Cooler extends StorageUnit  {
	PowerableUnit powerSupply = new PowerableUnit();
    public MinimumStock desiredMinimumStock = new MinimumStock();
    Orderer orderer = new Orderer();
    
    public Cooler(int capacity) {
    	super(capacity);
    	powerSupply.setPowerOn(false);
    }
    
    public void addBottle(String beverageName){
        Bottle newBottle = new Bottle(beverageName);
        add(newBottle);
    }
    
    public void addBottles(List<Bottle> beverageType) {
        for(Orderable order : beverageType){
        	add(order);
        }
    }
    
    public void addLocalStock(String beverageName, int beverageQuantity){
    	addBottles(localStock(beverageName, beverageQuantity));
    }
        
    private List<Bottle> localStock (String beverageName, int beverageQuantity){
    	List<Bottle> toAdd = new ArrayList<Bottle>();
    	for(int i = 0; i< beverageQuantity; i++){
        	toAdd.add(new Bottle(beverageName));
        }
    	return toAdd;
    }
    
    public void removeBottle(String beverageName){
    	removeFirstBottle(beverageName);
        reorderIfNecessary(beverageName);
    }

    private void removeFirstBottle(String beverageName) {
		for(Orderable item : getStoredItems()){
    		if(item.getName() == beverageName){
    			remove(item);
    		}
    		break;
    	}
	}
    
    private void reorderIfNecessary(String beverageName) {
		int toOrder = reorderQuantityCheck(beverageName);
        if(toOrder > 0){
        	automaticReorder(beverageName);
        }
	}
    
    public void removeBottles(String beverageName, int quantityToRemove){
    	for(int i =0; i< quantityToRemove; i++){
    		removeBottle(beverageName);
    	}
    }
    
    public int getBottleCountByBeverage(String beverageName) {
        int beverageCount = 0;
        for(Orderable target : getStoredItems()){
            Bottle bottle = (Bottle) target;
        	beverageCount += (bottle.getBeverageName().equalsIgnoreCase(beverageName)) ? 1 : 0;
        }
        return beverageCount;
    }
    
    public double getBeveragePrice(String beverageName){
    	double result = 0.0;
    	for(Orderable ordered : getStoredItems()){
    	if(beverageName == ordered.getName()){
	            result = ordered.getPrice();
	        }
	    }
	    return result;
	}
	
	public double getTotalStockValue(){
	    double totalStockValue = 0.00;
	    for(Orderable ordered: getStoredItems()){
	        totalStockValue += ordered.getPrice();
	    }
	    return totalStockValue;
	}
	
	double getStockValueByBeverage(String beverageName) {
        double stockValueByType = 0.00;
        for(Orderable ordered: getStoredItems()){
            if(beverageName == ordered.getName()){
                stockValueByType += ordered.getPrice();
            }
        }
        return stockValueByType;
    }
	
	public void setDesiredMinimumStock(String beverageName, int beverageQuantity) {
		desiredMinimumStock.update(beverageName, beverageQuantity);
	}

	public int getDesiredMinimumStock(String beverageName) {
		return desiredMinimumStock.getThreshold(beverageName);
		}
	
	public int reorderQuantityCheck(String beverageName) {
    	int onHand = this.getBottleCountByBeverage(beverageName);
		int threshold = this.getDesiredMinimumStock(beverageName);
		int toOrder = threshold - onHand;
		return toOrder;
		}
	
	private boolean thereIsAnOrderPending(){
		if(orderer.checkOrder() == null){
			return false;
		}
		else{
			return true;
		}
	}
	
	private void automaticReorder(String beverageName){
			Orderable toOrder = new Bottle(beverageName);
			if(thereIsAnOrderPending()){
				orderer.addToOrder(toOrder, 1);
			}
			else{
				orderer.createOrder(toOrder, 1, this);
			}
	}

	public void setPowerOn(boolean powerState) {
		powerSupply.setPowerOn(powerState);
	}

	public boolean isPowerOn() {
		return powerSupply.isPowerOn();
	}
}
		

    

