package hanifi.siavash.iv1350.processSale.data;
/**
 * Stores information about a specific merchandise 
 * @author Siavash
 *
 */
public class ItemDTO {

	private final int id;
	private final double price;
	private final String itemDescription;
	private final boolean isValid; 
	/**
	 * Creates an instance of an item, storing its id, price and an description
	 * of it.
	 * @param id
	 * @param price
	 * @param itemDescription
	 */
	public ItemDTO(int id, double price, String itemDescription) {
		this.id = id;
		this.price = price;
		this.itemDescription = itemDescription;
		this.isValid = true;
	}
	
	/**
	 * Creates an instance of an item which cannot be found in the database
	 * @param id The id which was used in the attempt to find the item.
	 */
	public ItemDTO(int id){
		this.id = id;
		this.isValid = false;						/*ADDED FOR SEMINAR 4*/
		this.itemDescription = "InvalidItem";
		this.price = 0;
	}
	
	public int getId() {
		return this.id;
	}

	public double getPrice() {
	return this.price;
	}

	public String toString() {
		return this.itemDescription;
	}

	public boolean isValid() {
		return this.isValid;
	}
	

}
