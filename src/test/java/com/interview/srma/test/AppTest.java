package com.interview.srma.test;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	

	@Before
	public void setUp() {
		
	}
	
	@After
	public void tear() {
		
	}
	
	@Test
	public void isCartEmpty()
	{
		ShoppingCart cart = new ShoppingCart();
		Assert.assertEquals(0, cart.getTotalNoOfItems());
	}
	
	@Test
	public void addOneItem()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item(ItemType.APPLE, new BigDecimal("0.60")), 1);
		Assert.assertEquals(1, cart.getTotalNoOfItems());		
	}
	
	@Test
	public void addDifferentItemsAndGetTotalCount()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item(ItemType.APPLE, new BigDecimal("0.60")), 1);
		cart.addItem(new Item(ItemType.ORANGE, new BigDecimal("0.25")), 1);
		Assert.assertEquals(2, cart.getTotalNoOfItems());		
	}

	@Test
	public void getTotalPriceForEmptyCart()
	{
		ShoppingCart cart = new ShoppingCart();
		Assert.assertEquals(new BigDecimal("0"), cart.getTotalPrice());
	}
	
	@Test
	public void addOneItemAndGetTotalPrice()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item(ItemType.APPLE, new BigDecimal("0.60")), 1);
		Assert.assertEquals(new BigDecimal("0.60"), cart.getTotalPrice());	
	}
	
	@Test
	public void addDifferentAndGetTotalPrice()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item(ItemType.APPLE, new BigDecimal("0.60")), 1);
		cart.addItem(new Item(ItemType.ORANGE, new BigDecimal("0.25")), 1);
		Assert.assertEquals(new BigDecimal("0.85"), cart.getTotalPrice());	
	}
	
	@Test
	public void addDifferentBulkItemsAndGetTotalCount()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item(ItemType.APPLE, new BigDecimal("0.60")), 4);
		cart.addItem(new Item(ItemType.ORANGE, new BigDecimal("0.25")), 3);
		Assert.assertEquals(7, cart.getTotalNoOfItems());		
	}
	
	//4*0.60 + 3*0.25
	@Test
	public void addDifferentBulkItemsAndGetPrice()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item(ItemType.APPLE, new BigDecimal("0.60")), 4);
		cart.addItem(new Item(ItemType.ORANGE, new BigDecimal("0.25")), 3);
		Assert.assertEquals(new BigDecimal("3.15"), cart.getTotalPrice());		
	}
	
}
