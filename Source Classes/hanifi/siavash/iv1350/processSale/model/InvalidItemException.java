package hanifi.siavash.iv1350.processSale.model;
/**
 * Thrown when an invalid item is registered to the sale.
 * @author Siavash
 *
 */
public class InvalidItemException extends Exception{
	private int itemId;
	/**
	 * Creates an exception storing the id of the invalid <code>Item</code>
	 * and information about the error condition.
	 * @param itemId The id of the invalid Item
	 */
	public InvalidItemException(int itemId) {
		super("Invalid item with id: " + itemId + ", cannot be added to sale");
		this.itemId	= itemId;
	}
	
	public int getItemId(){
		return this.itemId;
	}
}
