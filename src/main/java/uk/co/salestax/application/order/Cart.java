package uk.co.salestax.application.order;

import java.util.ArrayList;
import java.util.List;

import uk.co.salestax.application.domain.Item;
import uk.co.salestax.application.util.TaxCalculationUtil;

/**
 * Class for Cart which is holds items selected for shopping
 * @author Mahantayya Hiremath
 *
 */
public class Cart {

	private List<Item> itemList;
	private String orderId;

	public String getOrderId() {
		return orderId;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	/**
	 * @param orderId
	 * @throws IllegalArgumentException
	 */
	public Cart(String orderId) throws IllegalArgumentException {
		if (orderId == null || orderId.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid Order ID");
		}
		itemList = new ArrayList<Item>();
		this.orderId = orderId;
	}

	public Item addItem(String name, String unitPrice, String quantity) throws IllegalArgumentException {
		try {
			return addItem(new Item(name, unitPrice, quantity));
			
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid argument for items in Cart " + e.getMessage());
		}
	}

	private Item addItem(Item item) {
		TaxCalculationUtil.populateTaxDetails(item);
		itemList.add(item);
		return item;
	}



}
