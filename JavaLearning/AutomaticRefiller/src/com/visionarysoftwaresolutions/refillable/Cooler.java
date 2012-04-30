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

    void addBottles(List<Bottle> beverageType) {
        bottles.addAll(beverageType);
    }

    int getBeverageCount(String beverageName) {
        int beverageCount = 0;
        for(Bottle target : bottles){
            beverageCount += (target.getBeverageName().equalsIgnoreCase(beverageName)) ? 1 : 0;
        }
        return beverageCount;
    }

    void setCapacity(int capacity) {
        this.capacity=capacity;
    }
    
    int getCapacity(){
        return capacity;
    }
    
    int getPercentFull(){
        double percent;
        int bottlesInCooler = bottles.size();
        percent = (double) bottlesInCooler / (double) capacity;
        percent *= 100;
        return (int) percent;
    }
    
}
