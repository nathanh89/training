package com.visionarysoftwaresolutions.refillable;

import com.visionarysoftwaresolutions.ordering.Orderable;
import com.visionarysoftwaresolutions.ordering.Orderer;
import com.visionarysoftwaresolutions.ordering.StorageUnit;

class Cooler extends StorageUnit  {
	PowerableUnit powerSupply = new PowerableUnit();
    public MinimumStock desiredMinimumStock = new MinimumStock();
    Orderer orderer = new Orderer(this);
    
    public Cooler(int capacity) {
    	super(capacity);
    	powerSupply.setPowerOn(false);
    }
    
    public void addBottles(String beverageName, int quantityToAdd) {
        for(int i =0; i< quantityToAdd; i++){
        	addBottle(beverageName);
        }
    }
    
    public void addBottle(String beverageName){
        Bottle newBottle = new Bottle(beverageName);
        add(newBottle);
    }
    
    public void removeBottles(String beverageName, int quantityToRemove){
    	for(int i =0; i< quantityToRemove; i++){
    		removeBottle(beverageName);
    	}
    }
    
    public void removeBottle(String beverageName){
    	removeFirstBottle(beverageName);
        reorderIfNecessary(beverageName);
    }

    private void removeFirstBottle(String beverageName) {
		for(Orderable item : getStoredItems()){
    		if(item.getName() == beverageName){
    			remove(item);
    			break;
    		}
    	}
	}
    
    private void reorderIfNecessary(String beverageName) {
		int toOrder = reorderQuantityCheck(beverageName);
        if(toOrder > 0){
        	automaticReorder(beverageName);
        }
	}
    
    public int reorderQuantityCheck(String beverageName) {
    	int onHand = this.getCountForProduct(beverageName);
		int threshold = this.getDesiredMinimumStock(beverageName);
		int toOrder = threshold - onHand;
		return toOrder;
	}
    
    public void setDesiredMinimumStock(String beverageName, int beverageQuantity) {
		desiredMinimumStock.update(beverageName, beverageQuantity);
	}

	public int getDesiredMinimumStock(String beverageName) {
		return desiredMinimumStock.getThreshold(beverageName);
		}
	
	private void automaticReorder(String beverageName){
			Orderable toOrder = new Bottle(beverageName);
			if(thereIsAnOrderPending()){
				orderer.addToOrder(toOrder, 1);
			}
			else{
				orderer.createOrder(toOrder, 1);
			}
	}
	
	private boolean thereIsAnOrderPending(){
		return orderer.checkOrder() != null;
	}

	public void setPowerOn(boolean powerState) {
		powerSupply.setPowerOn(powerState);
	}

	public boolean isPowerOn() {
		return powerSupply.isPowerOn();
	}
}