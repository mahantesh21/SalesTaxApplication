/**
 * 
 */
package uk.co.salestax.application.exception;

/**
 * @author Mahantayya Hiremath
 * Custom exception to wrap application specific messages
 */
public class SalesTaxApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SalesTaxApplicationException(String message) {
		super(message);
	}

	public SalesTaxApplicationException(Throwable cause) {
		super(cause);
	}

	public SalesTaxApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

}
