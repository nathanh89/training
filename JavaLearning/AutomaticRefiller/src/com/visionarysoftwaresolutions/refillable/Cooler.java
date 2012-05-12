package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

class Cooler extends StorageUnit {
    private int capacity;
    private List<Bottle> bottles = new ArrayList<Bottle>();
    public MinimumStock desiredMinimumStock = new MinimumStock();
    Orderer orderer = new Orderer();
    
    
    public Cooler(int capacity) {
    	this.capacity = capacity;
    	setPowerOn(false);
    }
    
	public Cooler() {
	}

	public void addBottle(String beverageName){
        Bottle newBottle = new Bottle(beverageName);
        bottles.add(newBottle);
    }
    
    public void addBottles(List<Bottle> beverageType) {
        bottles.addAll(beverageType);
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
    	int initial = this.getBottleCountByBeverage(beverageName);
        for(int i = 0; i<bottles.size(); i++){
        	if(initial == this.getBottleCountByBeverage(beverageName)){
        		if(bottles.get(i).getBeverageName() == beverageName){
        			bottles.remove(i);
        		}
        	}
        }
        int toOrder = reorderQuantityCheck(beverageName);
        if(toOrder > 0){
        	automaticReorder(beverageName, this);
        }
    }
    
    public void removeBottles(String beverageName, int beverageQuantity){
    	List<Bottle> toRemove = new ArrayList<Bottle>();
    	for(int i = 0; i< beverageQuantity; i++){
        	toRemove.add(new Bottle(beverageName));
        }
    	for(int i = 0; i<toRemove.size(); i++){
    		removeBottle(toRemove.get(i).getBeverageName());
    	}
    }
    
    public int getTotalBottleCount(){
        return bottles.size();
    }
    
    public int getBottleCountByBeverage(String beverageName) {
        int beverageCount = 0;
        for(Bottle target : bottles){
            beverageCount += (target.getBeverageName().equalsIgnoreCase(beverageName)) ? 1 : 0;
        }
        return beverageCount;
    }
    
    public int getCapacity(){
        return capacity;
    }
        
   public void setCapacity(int desired) {
    	vetoInvalidCapacity(desired);
        capacity = desired;
    }
    
   private void vetoInvalidCapacity(int desired){
    	if(desired > capacity){
    		throw new RuntimeException("That's more than I can hold!");
    	}
    }
      
   public int getPercentFull(){
       double percent;
       int bottlesInCooler = bottles.size();
       percent = (double) bottlesInCooler / (double) capacity;
       percent *= 100;
       return (int) percent;
   }
      
	public void setBeveragePrice(String beverageName, double newPrice){
	    for(int i=0; i<bottles.size(); i++){
	        if(beverageName == bottles.get(i).getBeverageName()){
	            bottles.get(i).price = newPrice;
	        }
	    }
	}
	
	public double getBeveragePrice(String beverageName){
	    for(int i=0; i<bottles.size(); i++){
	        if(beverageName == bottles.get(i).getBeverageName()){
	            double price = bottles.get(i).getPrice();
	            return price;
	        }
	    }
	    return 0.00;
	}
	
	public double getTotalStockValue() {
	    double totalStockValue = 0.00;
	    for(int i=0; i<bottles.size(); i++){
	        totalStockValue += bottles.get(i).getPrice();
	    }
	    return totalStockValue;
	}
	
	double getStockValueByBeverage(String beverageName) {
        double stockValueByType = 0.00;
        for(int i=0; i<bottles.size(); i++){
            if(beverageName == bottles.get(i).getBeverageName()){
                stockValueByType += bottles.get(i).getPrice();
            }
        }
        return stockValueByType;
    }
	
	public void checkNotMoreThanCapacity(int desired) throws RuntimeException {
		if(desired + getTotalBottleCount() > capacity){
            throw new RuntimeException("That's more bottles than the cooler can hold!");
        }
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
	
	private void automaticReorder(String beverageName, Cooler toDeliver){
			if(thereIsAnOrderPending()){
				orderer.addToOrder(beverageName, 1, this);
			}
			else{
				orderer.createOrder(beverageName, 1, this);
				}
			}
}
		

    

