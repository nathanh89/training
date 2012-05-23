package com.visionarysoftwaresolutions.hfdpch4.tddstyle.nypizza;

import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.PizzaIngredientFactory;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.CheesePizza;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.ClamPizza;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.PepperoniPizza;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.Pizza;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.PizzaStore;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.VeggiePizza;

public class NYPizzaStore extends PizzaStore {
 
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
 
		if (item.equals("cheese")) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
  
		} else if (item.equals("veggie")) {
 
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
 
		} else if (item.equals("clam")) {
 
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
 
		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
 
		} 
		return pizza;
	}
}
