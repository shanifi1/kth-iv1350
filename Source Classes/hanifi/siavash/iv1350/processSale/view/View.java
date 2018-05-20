package hanifi.siavash.iv1350.processSale.view;
import hanifi.siavash.iv1350.processSale.controller.Controller;
import hanifi.siavash.iv1350.processSale.controller.ExternalSystemFailureException;
import hanifi.siavash.iv1350.processSale.controller.OperationFailedException;
import hanifi.siavash.iv1350.processSale.data.ItemDTO;
import hanifi.siavash.iv1350.processSale.dbhandler.ItemDBHandlerException;
import hanifi.siavash.iv1350.processSale.logging.LogHandler;
import hanifi.siavash.iv1350.processSale.model.Change;
import hanifi.siavash.iv1350.processSale.model.InvalidItemException;
import hanifi.siavash.iv1350.processSale.model.Payment;
/**
* This program has no view, instead, this class is a
* placeholder for the entire view.
*/
public class View {
	private Controller controller = null;
	private ErrorMessageHandler errorMessageHandler = null;
	private LogHandler logHandler = null;
	
	private void presentChangeInfo(Change change) {
		System.out.println("*************");
		System.out.println("Change: " + change.getChangeAmount().getCashAmount());
		System.out.println("*************");
	}

	private void presentDescription(ItemDTO itemDTO) {
		System.out.println("(Item registered)" + itemDTO.toString() + ", " + itemDTO.getPrice() + ":-");
	}
	
	private void presentPaymentInfo(Payment payment) {
		System.out.println();
		System.out.println("Price(tax included): " + payment.getTotalTaxInc());
		System.out.println();
	}	
	
	private void notifyNewSaleStarted() {
		System.out.println("******************");
		System.out.println("New sale started.");
		System.out.println("******************");
	}
	
	private void handleException(String userErrorMessage, Exception exception) { //Duplicated code ->Extract Method
		 errorMessageHandler.showErrorMsg(userErrorMessage); 
		 logHandler.logException(exception);
	}
	
	private void cashierStartsNewSale() {
		controller.startSale();
		notifyNewSaleStarted();
	}

	private void cashierScansItem(int itemId) {
		try {
		presentDescription(controller.registerItem(itemId));
		}
		catch(OperationFailedException operationFailedException){
			handleException("Failed to register item with id: " + ((InvalidItemException) operationFailedException.getCause()).getItemId(), operationFailedException);
		}
		catch(ExternalSystemFailureException externalSystemFailureException) {
			handleException(externalSystemFailureException.getMessage() + ", contact admin.", externalSystemFailureException);
		}
	}
	
	private void cashierSignalsAllItemsRegistered(){
		presentPaymentInfo(controller.allItemsRegistered());
	}
	
	private void cashierSignalsCompleteSale(double cashAmount) {	
		presentChangeInfo(controller.completeSale(cashAmount));
	}
	
	/**
	 * Creates a new instance
	 * @param controllerParam The controller that is used for all operations.
	 */
	public View(Controller controller) {
		this.controller = controller;
		this.errorMessageHandler = new ErrorMessageHandler();
		this.logHandler = new LogHandler();
		controller.addSaleObserver(new TotalRevenueView()); //NULLPOINTERException
	}
	
	private  void firstSaleSampleExecution() {
		int itemId;
		this.cashierStartsNewSale();
		itemId=647474; //itemId for a banana
		this.cashierScansItem(itemId);
		itemId=576483; //itemId for a strawberry
		this.cashierScansItem(itemId);
		//itemId=123415; //example of an invalid itemId
		//this.cashierScansItem(itemId);
		itemId=576483; //itemId for a strawberry
		this.cashierScansItem(itemId);
		//itemId=666; //itemId which triggers the simulated database failure
		//this.cashierScansItem(itemId);
		this.cashierSignalsAllItemsRegistered();
		this.cashierSignalsCompleteSale(50);
	}
	private void secondSaleSampleExecution() {
		int itemId;
		this.cashierStartsNewSale();
		itemId=647474; //itemId for a banana
		this.cashierScansItem(itemId);
		itemId=576483; //itemId for a strawberry
		this.cashierScansItem(itemId);
		this.cashierSignalsAllItemsRegistered();
		this.cashierSignalsCompleteSale(20);
	}
	
	/**
	 *	Hard-coded input simulating the cashiers interaction with the view.
	 * @throws OperationFailedException If a cashier-made operation fails.
	 */
	public void sampleExecution() throws OperationFailedException {
		
		/*
		 * First sale
		 */
		firstSaleSampleExecution();
		
		/*
		 * Second sale
		 */
		secondSaleSampleExecution();
	}
	
	
}
