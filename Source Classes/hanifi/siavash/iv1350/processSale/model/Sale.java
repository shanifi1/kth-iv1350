package hanifi.siavash.iv1350.processSale.model;
import java.util.Vector;
import hanifi.siavash.iv1350.processSale.data.ItemDTO;
import java.util.Date;
/**
 * Contains functionality and information of the ongoing sale.
 * @author Siavash
 *
 */
public class Sale {
	
	private Date date;
	private Vector<ItemDTO> listOfItems = new Vector<ItemDTO>();
	private double runningTotal = 0;
	
	private void calculateRunningTotal(){
		this.runningTotal += listOfItems.lastElement().getPrice();
	}
	/**
	 * Initializes and instantiates a new sale.
	 */
	public Sale() {
		this.date = new Date();
	}
	
	/**
	 * Registers an item to the ongoing sale.
	 * @param scannedItem
	 * @throws InvalidItemException If an attempt to registar an invalid item is made.
	 */
	public void registerItem(ItemDTO scannedItem) throws InvalidItemException {/*ADDED FOR SEMINAR 4*/
		if(!scannedItem.isValid())
			throw new InvalidItemException(scannedItem.getId()); /*ADDED FOR SEMINAR 4*/
		listOfItems.addElement(scannedItem);
		calculateRunningTotal();
	}

	public double getRunningTotal() {
		return this.runningTotal;
	}

	public Vector<ItemDTO> getListOfItems() {
		return this.listOfItems;
	}
	
	public Date getDate() {
		return this.date;
	}
}
