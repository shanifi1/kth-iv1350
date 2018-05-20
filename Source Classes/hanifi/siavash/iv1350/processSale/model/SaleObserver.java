package hanifi.siavash.iv1350.processSale.model;

/**
 * A listener interface for receiving notifications about
 * completed sales. The class that is interested in such
 * notifications implements this interface, and the object
 * created with that class is registered with {@link
 * hanifi.siavash.iv1350.processSale.controller.
 * Controller#addSaleObserver(SaleObserver)}. When a
 * sale is completed, that object’s {@link #completeSale} completeSale
 * method is invoked.
 */
public interface SaleObserver {
	
	/**
	 * Invoked when a sale has been completed.
	 * @param sale the <code>Sale</code> that was completed.
	 */
	void saleHasBeenCompleted(Sale sale);
	
	/**
	 * Invoked when a sale has been completed.
	 * 
	 */
	//void saleHasBeenCompleted();
}
