package hanifi.siavash.iv1350.processSale.dbhandler;
import hanifi.siavash.iv1350.processSale.data.ItemDB;
import hanifi.siavash.iv1350.processSale.data.ItemDTO;

/**
 * Communicates with and handles the database. 
 * @author Siavash
 *
 */
public class ItemDBHandler {

	/**
	 * Hard-coded simulation of the fetching of an item in the database containing items.
	 *  
	 * @param itemId The identifier for the searched item.
	 * @return The identified <code>Item</code>-object.
	 * @throws ItemDBHandlerException If the itemId is 666, simulating a database failure.
	 */
	public ItemDTO fetchItem(int itemId) throws ItemDBHandlerException{	//If the InvalidItemException was to be thrown here
											//the exception's purpose to handle error
											//would devolve to being a part of the programs
											//functionality and main flow.
		if(itemId == 666) {
			throw new ItemDBHandlerException("Database failure, could not establish connection with database");
		}
		if(itemId == 647474) {
			return  ItemDB.Banana;
		}
		else if(itemId == 576483) {
			return ItemDB.Strawberry;
		}
		else return new ItemDTO(itemId); /*ADDED FOR SEMINAR 4*/
	}
	
}
