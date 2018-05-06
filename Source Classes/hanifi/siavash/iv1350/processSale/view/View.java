package hanifi.siavash.iv1350.processSale.view;
import hanifi.siavash.iv1350.processSale.controller.Controller;
import hanifi.siavash.iv1350.processSale.data.ItemDTO;
import hanifi.siavash.iv1350.processSale.model.Change;
import hanifi.siavash.iv1350.processSale.model.Payment;
/**
* This program has no view, instead, this class is a
* placeholder for the entire view.
*/
public class View {
	
	private Controller controller;
	
	private void presentChangeInfo(Change change) {
		// TODO Auto-generated method stubs
		System.out.println();
		System.out.println("Change: " + change.getChangeAmount().getCashAmount());
	}
	
	private void presentPaymentInfo(Payment payment) {
		System.out.println();
		System.out.println("Price(tax included): " + payment.getTotalTaxInc());
	}	
	
	/**
	 * Creates a new instance and displays information about changes in the ongoing sale
	 * 
	 * @param controllerParam The controller that is used for all operations.
	 */
	public View(Controller controller) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
	}
	
	/**
	 * View-Output: Presents the description of an <code>Item</code>
	 * @param itemDTO The <code>Item</code>
	 */
	private void presentDescription(ItemDTO itemDTO) {
		System.out.println();
		System.out.println("(Item registered)" + itemDTO.toString());
	}
	

	/**
	 * Presents the changes
	 *
	public void presentSaleStateChanges() {
		controller.getSaleInformation();
	}*/
	
	/**
	 * A hard-coded simulation of the view's reaction to the cashier's signaling to start a new sale.
	 */
	public void cashierStartsNewSale() {
		controller.startSale();
		System.out.println("New sale started.");
	}
	
	/**
	 * A hard-coded simulation of the view's reaction to the cashier's act of scanning an item.
	 * @param itemId The item-identifier
	 */
	public void cashierScansItem(int itemId) {
		presentDescription(controller.registerItem(itemId));
	}
	
	/**
	 * A hard-coded simulation of the view's reaction to the cashier's signaling that all the items have been registered
	 */
	public void cashierSignalsAllItemsRegistered(){
		presentPaymentInfo(controller.allItemsRegistered());
	}
	
	/**
	 * A hard-coded simulation of the view's reaction to the cashier's signaling that the sale is to be completed.
	 * @param cashAmount The amount of cash received from the customer.
	 */
	public void cashierSignalsCompleteSale(double cashAmount) {	
		presentChangeInfo(controller.completeSale(cashAmount));
	}
	
	/**
	 * 
	 */
	public void sampleExecution() {
		this.cashierStartsNewSale();
		this.cashierScansItem(647474);
		this.cashierScansItem(576483);
		this.cashierSignalsAllItemsRegistered();
		this.cashierSignalsCompleteSale(1000);
	}
	
	
}
