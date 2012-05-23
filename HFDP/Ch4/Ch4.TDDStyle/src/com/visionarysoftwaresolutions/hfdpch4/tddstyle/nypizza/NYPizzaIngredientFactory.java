package com.visionarysoftwaresolutions.hfdpch4.tddstyle.nypizza;

import com.visionarysoftwaresolutions.hfdpch4.tddstyle.chicagopizza.SlicedPepperoni;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Cheese;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Clams;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Dough;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Pepperoni;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.PizzaIngredientFactory;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Sauce;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
