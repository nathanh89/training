package com.visionarysoftwaresolutions.hfdpch4.tddstyle.chicagopizza;

import com.visionarysoftwaresolutions.hfdpch4.tddstyle.ingredients.PizzaIngredientFactory;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.CheesePizza;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.ClamPizza;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.PepperoniPizza;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.Pizza;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.PizzaStore;
import com.visionarysoftwaresolutions.hfdpch4.tddstyle.pizzas.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
		new ChicagoPizzaIngredientFactory();

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");

		} else if (item.equals("clam")) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");

		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		return pizza;
	}
}
