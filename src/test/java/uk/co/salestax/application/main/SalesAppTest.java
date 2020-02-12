package uk.co.salestax.application.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.co.salestax.application.domain.Item;
import uk.co.salestax.application.order.Cart;
import uk.co.salestax.application.util.TaxCalculationUtil;

/**
 * Test class for Sale application
 * 
 * @author Mahantayya Hiremath
 */
public class SalesAppTest {
	Cart cartOne;
	Cart cartTwo;

	@Before
	public void setUp() throws Exception {
		cartOne = new Cart("Order One");
		cartTwo = new Cart("Order Two");
		cartOne.addItem("book", "12.49", "1");
		cartTwo.addItem("imported box of chocolate", "10.00", "1");
		cartTwo.addItem("imported bottle of perfume", "47.50", "1");
	}

	@After
	public void tearDown() throws Exception {
		cartOne = null;
		cartTwo = null;
	}

	@Test
	public void testCart_ValidConstructor() {
		cartOne = new Cart("Order One");
		assertTrue(cartOne.getOrderId() != null);
		assertEquals(cartOne.getOrderId(), "Order One");
		assertTrue(cartOne.getItemList() != null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCart__NullOrderId() {
		cartOne = new Cart(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCart__EmptyOrderId() {
		cartOne = new Cart("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCart__AddItem_Null_ItemName() {
		cartOne.addItem(null, "12.49", "1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCart__AddItem_Empty_ItemName() {
		cartOne.addItem("", "12.49", "1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCart__InvalidUnitPrice() {
		cartOne.addItem("book", "-12.49", "1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCart__InvalidQuantity() {
		cartOne.addItem("book", "12.49", "0");
	}

	@Test
	public void testCart__Itemsize__Quantity() {
		assertEquals(cartOne.getItemList().size(), 1);
		assertEquals(cartOne.getItemList().get(0).getQuantity(), 1);
	}

	@Test
	public void testCart_With_More_Items() {
		assertEquals(cartTwo.getItemList().size(), 2);
		assertTrue(cartTwo.getItemList().get(0) instanceof Item);
		assertTrue(cartTwo.getItemList().get(1) instanceof Item);
	}

	@Test
	public void testSales__TaxCalulation_Scenario1__ExemptedItem() {
		TaxCalculationUtil.populateTaxDetails(cartOne.getItemList().get(0));
		assertEquals(0.00, cartOne.getItemList().get(0).getItemTotalTax(), 2);
		assertEquals(12.49, cartOne.getItemList().get(0).getItemFinalPrice(), 2);

	}

	@Test
	public void testSales__TaxCalulation_Scenario2__ImportedItems() {
		TaxCalculationUtil.populateTaxDetails(cartOne.getItemList().get(0));
		assertEquals(10.00, cartTwo.getItemList().get(0).getUnitPrice(), 2);
		assertEquals(0.50, cartTwo.getItemList().get(0).getItemTotalTax(), 2);
		assertEquals(10.50, cartTwo.getItemList().get(0).getItemFinalPrice(), 2);

		TaxCalculationUtil.populateTaxDetails(cartTwo.getItemList().get(1));
		assertEquals(47.40, cartTwo.getItemList().get(1).getUnitPrice(), 2);
		assertEquals(7.25, cartTwo.getItemList().get(1).getItemTotalTax(), 2);
		assertEquals(54.65, cartTwo.getItemList().get(1).getItemFinalPrice(), 2);

	}

}
