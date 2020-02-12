package uk.co.salestax.application.domain;

import java.util.stream.Stream;

import uk.co.salestax.application.util.TaxCalculationUtil;

/**
 * Abstract class to define Items behaviour
 * 
 * @author Mahantayya Hiremath
 */
public class Item {
	private String name;
	private double unitPrice;
	private int quantity;
	private double basicTax;
	private double additionalTax;
	
	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public Item(String name, String unitPrice, String quantity) throws IllegalArgumentException {
		if (name == null || name.isEmpty() 
				||unitPrice == null || unitPrice.isEmpty() || Double.valueOf(unitPrice) <  0
				||quantity == null || quantity.isEmpty()|| Integer.valueOf(quantity) <= 0) {
			throw new IllegalArgumentException("Invalid arguments for Items");
		}
		this.name = name;
		this.quantity = Integer.valueOf(quantity);
		this.unitPrice = Double.valueOf(unitPrice);
	}

	public double getItemFinalPrice() {
		return TaxCalculationUtil.roundOffAmount(quantity * unitPrice + getItemTotalTax());
	}

	public double getItemTotalTax() {
		return quantity * (basicTax + additionalTax);
	}

	public boolean isImportedItem() {
		return name.contains("imported");
	}

	public boolean isTaxExemptedItem() {
		return Stream.of("book", "chocolate", "pill").anyMatch(exemptedItem -> name.contains(exemptedItem));
	}

	public void setBasicSalesTaxAmount(double factor) {
		basicTax = unitPrice * factor;
	}

	public void setAdditionalSalesTax(double additionalSalesTaxPercent) {
		additionalTax = TaxCalculationUtil.roundOffTax(unitPrice * additionalSalesTaxPercent);
	}

	public String toString() {
		return "\n " + String.valueOf(quantity) + " " + name + " : " + getItemFinalPrice();
	}
}
