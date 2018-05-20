package hanifi.siavash.iv1350.processSale.model;
import java.util.Vector;
import hanifi.siavash.iv1350.processSale.data.ItemDTO;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * Contains functionality and information of the ongoing sale.
 * @author Siavash
 *
 */
public class Sale {
	private boolean isCompleted = false;
	private Date date;
	private Vector<ItemDTO> listOfItems = new Vector<ItemDTO>();
	private double runningTotal = 0;
	private Vector<SaleObserver> observers = new Vector<>();
	
	private void notifySaleObservers() {
		for (SaleObserver observer : observers) {
			observer.saleHasBeenCompleted(this);
			}
	}
	
	public void completeSale() {
		this.isCompleted = true;
		notifySaleObservers();
	}
	
	private void calculateRunningTotal(){
		this.runningTotal += listOfItems.lastElement().getPrice();
	}
	
	/**
	 * Initializes and instantiates a new sale. Recording date and adding observer that calculates total revenue.
	 */
	public Sale() {
		this.date = new Date();
	}
		
	/**
	* Registers observers. Any <code>SaleObserver</code> that is
	* passed to this method will be notified when this object
	* changes state.
	*
	* @param observer The observer that shall be registered.
	*/
	public void addSaleObservers(Vector<SaleObserver> saleObserver) {
		 this.observers.addAll(saleObserver);
	 }
	
	/**
	 * Registers an item to the ongoing sale.
	 * @param scannedItem
	 * @throws InvalidItemException If an attempt to register an invalid item is made.
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
