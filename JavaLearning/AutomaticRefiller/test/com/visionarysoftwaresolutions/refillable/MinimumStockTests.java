package com.visionarysoftwaresolutions.refillable;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumStockTests {

	@Test
	public void testSetMiniumumStockSingleProduct() {
		//When I define Minimum Stock for a product
		MinimumStock minStock = new MinimumStock();
		minStock.update("Monster", 10);
		//Then that value should be set
		assertEquals(10, minStock.getThreshold("Monster"));
	}
	
	@Test public void testSetMinimumStockMulitpleProducts(){
		//When I define Minimum Stock for multiple products
		MinimumStock minStock = new MinimumStock();
		minStock.update("Monster", 10);
		minStock.update("Rockstar", 15);
		//Then those values should be set
		assertEquals(10, minStock.getThreshold("Monster"));
		assertEquals(15, minStock.getThreshold("Rockstar"));
	}

}
