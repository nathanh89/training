package com.visionarysoftwaresolutions.hfdpch4.tddstyle.chicagopizza;

import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Cheese;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Clams;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Dough;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Pepperoni;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.PizzaIngredientFactory;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Sauce;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}