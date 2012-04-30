package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

class Cooler implements PoweredDooredUnit {
    boolean powerOn = false;
    boolean doorOpen = false;
    int currentBottles = 0;
    List<Bottle> bottles = new ArrayList();
    
    
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
    
    public void addBottles(int newBottles){
        currentBottles += newBottles;
    }
    
    public int getBottles(){
        return currentBottles;
    }
    
    public void removeBottles(int lessBottles){
        currentBottles -= lessBottles;
    }

    void addBottles(List<Bottle> beverageType) {
        bottles.addAll(beverageType);
    }

    int getBeverageCount(String beverageName) {
        int beverageCount = 0;
        for(int i=0; i<bottles.size(); i++){
            Bottle target = bottles.get(i); 
            if(target.getBeverageName().equalsIgnoreCase(beverageName)){
                beverageCount++;
            }
        }
        return beverageCount;
    }
    
}
