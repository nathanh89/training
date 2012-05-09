package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

class Cooler implements PoweredDooredUnit {
    private boolean powerOn = false;
    private boolean doorOpen = false;
    private int capacity;
    private List<Bottle> bottles = new ArrayList<Bottle>();
    private MinimumStock desiredMinimumStock = new MinimumStock();
    Orderer orderer = new Orderer();
    
    
    public Cooler(int capacity) {
    	this.capacity = capacity;
    	setPowerOn(false);
    }
    
	public Cooler() {
	}

	@Override
    public boolean isPowerOn() {
        return powerOn;
    }

    @Override
    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    @Override
    public void togglePower() {
        setPowerOn(!powerOn);
    }
    
    @Override
    public boolean isDoorOpen(){
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
    
    public Orderable removeBottle(){
        if(!isPowerOn()){
            throw new RuntimeException("I'm not even on!");
        }
        if(!isDoorOpen()){
            operateDoor();
        };
        Orderable result = this.bottles.remove(this.bottles.size()-1);
        reorderWhenBelowMinimumStock(result);
        if(isDoorOpen()){
            operateDoor();
        };
        return result;
    }
    
    public int getTotalBottleCount(){
        return bottles.size();
    }
    
    public int getBottleCountByBeverage(String beverageName) {
        int beverageCount = 0;
        for(Orderable target : bottles){
            beverageCount += (target.getName().equalsIgnoreCase(beverageName)) ? 1 : 0;
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
	        if(beverageName == bottles.get(i).getName()){
	            bottles.get(i).price = newPrice;
	        }
	    }
	}
	
	public double getBeveragePrice(String beverageName){
	    for(int i=0; i<bottles.size(); i++){
	        if(beverageName == bottles.get(i).getName()){
	            double price = bottles.get(i).getBeverageValue();
	            return price;
	        }
	    }
	    return 0.00;
	}
	
	public double getTotalStockValue() {
	    double totalStockValue = 0.00;
	    for(int i=0; i<bottles.size(); i++){
	        totalStockValue += bottles.get(i).getBeverageValue();
	    }
	    return totalStockValue;
	}
	
	double getStockValueByBeverage(String beverageName) {
        double stockValueByType = 0.00;
        for(int i=0; i<bottles.size(); i++){
            if(beverageName == bottles.get(i).getName()){
                stockValueByType += bottles.get(i).getBeverageValue();
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
	
	    
    private void reorderWhenBelowMinimumStock(Orderable result) {
		String name = result.getName();
    	int onHand = this.getBottleCountByBeverage(name);
		int threshold = desiredMinimumStock.getThreshold(name);
		if(onHand < threshold){
			orderer.createOrder(name, threshold - onHand, this);
		}
	}

}
    

