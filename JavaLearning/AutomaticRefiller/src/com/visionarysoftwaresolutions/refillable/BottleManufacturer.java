package com.visionarysoftwaresolutions.refillable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathan
 */
public class BottleManufacturer {

    public static List<Bottle> orderSingleType(String beverageName, int beverageQuantity){
        List<Bottle> bottles = new ArrayList<Bottle>();
        for(int i=0; i<beverageQuantity; i++){
            bottles.add(new Bottle(beverageName));
        }
        return bottles;
    }
}
