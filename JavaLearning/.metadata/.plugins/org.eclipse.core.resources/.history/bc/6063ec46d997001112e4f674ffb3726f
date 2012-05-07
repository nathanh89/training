package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

class Cooler implements PoweredDooredUnit {
    boolean powerOn = false;
    boolean doorOpen = false;
    int capacity;
    List<Bottle> bottles = new ArrayList<Bottle>();
    
    
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
    
    public int getBottles(){
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
        if(isDoorOpen()){
            operateDoor();
        };
        return result;
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

    public void order(BottleManufacturer source, String beverageType, int beverageQuantity) {
    	// when we try to order more, first check that we're not trying to order more than we can hold
    	checkNotMoreThanCapacity(getCapacity() + beverageQuantity);
    	// then we want to place the order
    	Order newOrder = new Order(beverageType, beverageQuantity);
    	List<Bottle> result = source.place(newOrder);
    	// add the ordered bottles to our storage
        bottles.addAll(result);
     }

	private void checkNotMoreThanCapacity(int desired) throws RuntimeException {
		if(desired > capacity){
            throw new RuntimeException("That's more bottles than the cooler can hold!");
        }
	}
}
    

