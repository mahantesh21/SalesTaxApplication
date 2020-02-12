package uk.co.salestax.application.main;

import uk.co.salestax.application.exception.SalesTaxApplicationException;
import uk.co.salestax.application.order.Cart;
import uk.co.salestax.application.order.PurchaseOrder;

/**
 * Sale tax application main entry point
 */
public class SalesApp {
	/**
	 * Main method to execute program
	 */
	public static void main(String[] args) {
		System.out.println("=========================================================");
		System.out.println("Hello, This is the application to calculate Sales Tax");
		
		try {
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			/* Adding each items manually, Scanner or any other means of input can be implemented if required.
			   Keep it simple for this exercise
			*/

			Cart cartOne = new Cart("SA01");
			cartOne.addItem("book", "12.49", "1");
			cartOne.addItem("music CD", "14.99", "1");
			cartOne.addItem("chocolate bar", "0.85", "1");
			purchaseOrder.addToCart(cartOne);

			Cart cartTwo = new Cart("SA02");
			cartTwo.addItem("imported box of chocolate", "10.00", "1");
			cartTwo.addItem("imported bottle of perfume", "47.50", "1");
			purchaseOrder.addToCart(cartTwo);

			Cart cartThree = new Cart("SA03");
			cartThree.addItem("imported bottle of perfume", "27.99", "1");
			cartThree.addItem("bottle of perfume", "18.99", "1");
			cartThree.addItem("packet of headache pills", "9.75", "1");
			cartThree.addItem("box of imported chocolates", "11.25", "1");
			purchaseOrder.addToCart(cartThree);

			System.out.println(purchaseOrder.printShoppingReciept());

		} catch (IllegalArgumentException e) {
			// Throwing Application specific exception, we can handle specifically
			throw new SalesTaxApplicationException(
					"Error occurred in Sales Tax application, Please retry with valid Items" + e.getMessage());
		}

	}
}
