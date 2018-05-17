package hanifi.siavash.iv1350.processSale.controller;

import hanifi.siavash.iv1350.processSale.dbhandler.ItemDBHandlerException;
/**
 * Thrown when operations using external systems fail.
 * @author Siavash
 *
 */
public class ExternalSystemFailureException extends RuntimeException {
	/**
	 * Creates an exception storing information about the error condition
	 * and it's cause. 
	 * @param itemDBHandlerException The cause
	 * @param errorMessage The message describing the error condition.
	 */
	public ExternalSystemFailureException(ItemDBHandlerException itemDBHandlerException, String errorMessage) {
		 super(errorMessage, itemDBHandlerException);
	}

}
