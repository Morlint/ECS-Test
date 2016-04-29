/**
 * 
 */
package com.interview.srma.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Sheeba Arulmariadoss
 *
 */
public class ShoppingCart {

	private int totalNoOfItems = 0;
	private BigDecimal totalPrice = new BigDecimal("0");
	private List<Item> itemList = new ArrayList<Item>();

	// buy one get one
	private boolean buyOneGetOne;
	int totalNoOfItemsForBuyOneGetOne = 0;

	// buy two get one
	private boolean buyTwoGetOne;
	int totalNoOfItemsForBuyTwoGetOne = 0;

	public void addItem(Item item, int i) {
		// TODO Auto-generated method stub

		totalNoOfItems += i;

		totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(i)));

		if (totalNoOfItems > 1 && buyOneGetOne) {
			if ((totalNoOfItems % 2) == 1) {
				++totalNoOfItems;
			}
			totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(i)));
			totalPrice = totalPrice.divide(new BigDecimal("2"));
		} else {
			totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(i)));
		}

	}

	public int getTotalNoOfItems() {
		// TODO Auto-generated method stub
		return totalNoOfItems;
	}

	public void setTotalNoOfItems(int itemsBought) {
		this.totalNoOfItems = itemsBought;
	}

	public BigDecimal getTotalPrice() {
		// TODO Auto-generated method stub
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal price) {
		// TODO Auto-generated method stub
		totalPrice = price;
	}

	public void setBuyOneGetOne(boolean buyOneGetOne) {
		// TODO Auto-generated method stub
		this.buyOneGetOne = buyOneGetOne;
	}

	public boolean isBuyOneGetOne() {
		return buyOneGetOne;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	// now all are apples
	public void checkout() {
		// TODO Auto-generated method stub
		if (buyOneGetOne) {
			if ((totalNoOfItems % 2) == 1) {
				++totalNoOfItems;
			}
			totalPrice = totalPrice.divide(new BigDecimal("2"));
		}

	}

	public void applyBuyOneGetOneOffer() {
		if (buyOneGetOne && totalNoOfItemsForBuyOneGetOne > 0) {

		}
	}

	public boolean isBuyTwoGetOne() {
		return buyTwoGetOne;
	}

	public void setBuyTwoGetOne(boolean buyTwoGetOne) {
		this.buyTwoGetOne = buyTwoGetOne;
	}

}
