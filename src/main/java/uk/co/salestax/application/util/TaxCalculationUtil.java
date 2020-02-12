package uk.co.salestax.application.util;

import uk.co.salestax.application.domain.Item;


/**
 * Utility class to do tax related calculations
 * 
 * @author Mahantayya Hiremath
 *
 */
public final class TaxCalculationUtil {

    private static final double BASIC_TAXRATE = 0.10;
    private static final double IMPORTED_ITEM_ADDITIONAL_TAXRATE = 0.05;

	public static void populateTaxDetails(Item item) {
        if (!item.isTaxExemptedItem()) {
            item.setBasicSalesTaxAmount(BASIC_TAXRATE);
        }

        if (item.isImportedItem()) {
            item.setAdditionalSalesTax(IMPORTED_ITEM_ADDITIONAL_TAXRATE);
        }
    }
		
    public static double roundOffTax(double number) {
        return Math.ceil(number * 20) / 20;
    }

    public static double roundOffAmount(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

}
