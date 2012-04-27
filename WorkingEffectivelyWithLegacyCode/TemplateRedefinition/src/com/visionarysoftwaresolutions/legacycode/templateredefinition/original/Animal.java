package com.visionarysoftwaresolutions.legacycode.templateredefinition.original;

public class Animal {
    Walk behavior = new Walk();
    private boolean tired = false;
    
    public boolean isTired() {
        return tired;
    }

    public void setTired(boolean tired) {
        this.tired = tired;
    }
    
    public void walk(){
        behavior.doIt();
        setTired(true);
    }
    
    public void roar(){
        walk();
        System.out.println("roar");
    }
}
