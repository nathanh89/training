package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

class Cooler implements PoweredDooredUnit {
    private boolean powerOn = false;
    private boolean doorOpen = false;
    int capacity;
    List<Bottle> bottles = new ArrayList<Bottle>();
    MinimumStock desiredMinimumStock = new MinimumStock();
    Order pending;
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
    
    public void addBottle(Bottle toAdd){
        bottles.add(toAdd);
    }
    
    public int getBottleCount(){
        return bottles.size();
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

    private void reorderWhenBelowMinimumStock(Orderable result) {
		String name = result.getName();
    	int onHand = this.getBeverageCountByType(name);
		int threshold = desiredMinimumStock.getThreshold(name);
		if(onHand < threshold){
			orderer.createOrder(name, threshold - onHand, this);
		}
	}

	public void addBottles(List<Bottle> beverageType) {
        bottles.addAll(beverageType);
    }

    public int getBeverageCountByType(String beverageName) {
        int beverageCount = 0;
        for(Orderable target : bottles){
            beverageCount += (target.getName().equalsIgnoreCase(beverageName)) ? 1 : 0;
        }
        return beverageCount;
    }

    public void setCapacity(int capacity) {
        this.capacity=capacity;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public int getPercentFull(){
        double percent;
        int bottlesInCooler = bottles.size();
        percent = (double) bottlesInCooler / (double) capacity;
        percent *= 100;
        return (int) percent;
    }
    
    public void setBeveragePriceByType(String beverageName, double newPrice){
        for(int i=0; i<bottles.size(); i++){
            if(beverageName == bottles.get(i).getName()){
                bottles.get(i).price = newPrice;
            }
        }
    }
    
    public double getBeveragePriceByType(String beverageName){
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

    double getStockValueByType(String beverageName) {
        double stockValueByType = 0.00;
        for(int i=0; i<bottles.size(); i++){
            if(beverageName == bottles.get(i).getName()){
                stockValueByType += bottles.get(i).getBeverageValue();
            }
        }
        return stockValueByType;
    }

	
	public void setDesiredMinimumStock(String beverageName, int beverageQuantity) {
		desiredMinimumStock.update(beverageName, beverageQuantity);
	}

	public int getDesiredMinimumStock(String beverageName) {
		return desiredMinimumStock.getThreshold("Monster");
	}
	
	public void checkNotMoreThanCapacity(int desired) throws RuntimeException {
		if(desired + getBottleCount() > capacity){
            throw new RuntimeException("That's more bottles than the cooler can hold!");
        }
	}

}
    

