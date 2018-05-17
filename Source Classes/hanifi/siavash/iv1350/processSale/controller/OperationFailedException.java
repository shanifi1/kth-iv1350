package hanifi.siavash.iv1350.processSale.controller;

import hanifi.siavash.iv1350.processSale.dbhandler.ItemDBHandlerException;
import hanifi.siavash.iv1350.processSale.model.InvalidItemException;

/**
 * Thrown when a cashier-made operation fails
 * @author Siavash
 */
public class OperationFailedException extends Exception {
	/**
	 * Creates an exception for the scenario in which the registration 
	 * of an item fails because the item could not be found.
	 * @param invalidItemException The cause
	 */
	OperationFailedException(InvalidItemException invalidItemException){
		super("Could not register Item with id: " + invalidItemException.getItemId(), invalidItemException);
	}
	
}