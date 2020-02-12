package uk.co.salestax.application.order;

import java.util.ArrayList;
import java.util.List;

import uk.co.salestax.application.domain.Item;
import uk.co.salestax.application.util.TaxCalculationUtil;

/**
 * @author Mahantayya Hiremath
 * This is wrapper class to hold cart list and print shopping summary
 */
public class PurchaseOrder {
	private List<Cart> cartList;
	private double totalSalesTax = 0.0;
	private double totalAmount = 0.0;

	public PurchaseOrder(List<Cart> itemCartList) throws IllegalArgumentException {
		if (itemCartList == null) {
			throw new IllegalArgumentException("Invalid ItemCart");
		}
		this.cartList = itemCartList;

	}

	public PurchaseOrder() {
		this(new ArrayList<Cart>());
	}

	public void addToCart(Cart ItemCart) throws IllegalArgumentException {
		if (cartList == null) {
			throw new IllegalStateException("Purchase order not Initialised");
		}
		this.cartList.add(ItemCart);
	}

	public String printShoppingReciept() {

		StringBuilder cartSummary = new StringBuilder();
		StringBuilder purchaseOrderSummary = new StringBuilder();

		if (cartList != null && !cartList.isEmpty()) {

			for (Cart cart : cartList) {
				totalSalesTax = 0;
				totalAmount = 0;
				cartSummary.append("\n =================================================");
				cartSummary.append("\n Summary for Order "+cart.getOrderId());
				cartSummary.append("\n =================================================");
				for (Item item : cart.getItemList()) {
					cartSummary.append(item.toString());
					totalSalesTax += item.getItemTotalTax();
					totalAmount += item.getItemFinalPrice();
				}
				totalAmount = TaxCalculationUtil.roundOffAmount(totalAmount);
				totalSalesTax = TaxCalculationUtil.roundOffAmount(totalSalesTax);
				cartSummary.append("\n \n Sales Taxes: " + totalSalesTax);
				cartSummary.append(" \n Total: " + totalAmount);
				cartSummary.append("\n \n");

			}

			purchaseOrderSummary.append(cartSummary);		
			} else {
			purchaseOrderSummary.append("No carts in Order.");
		}

		return purchaseOrderSummary.toString();
	}

}
