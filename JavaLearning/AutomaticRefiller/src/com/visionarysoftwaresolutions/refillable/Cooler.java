package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.Iterator;
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
    
    public Bottle removeBottle(){
        if(!isPowerOn()){
            throw new RuntimeException("I'm not even on!");
        }
        if(!isDoorOpen()){
            operateDoor();
        };
        Bottle result = this.bottles.remove(this.bottles.size()-1);
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
        for(Bottle target : bottles){
            beverageCount += (target.getBeverageName().equalsIgnoreCase(beverageName)) ? 1 : 0;
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
            if(beverageName == bottles.get(i).getBeverageName()){
                bottles.get(i).beveragePrice = newPrice;
            }
        }
    }
    
    public double getBeveragePriceByType(String beverageName){
        for(int i=0; i<bottles.size(); i++){
            if(beverageName == bottles.get(i).getBeverageName()){
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
}
    

