package hanifi.siavash.iv1350.processSale.startup;
import hanifi.siavash.iv1350.processSale.controller.Controller;
import hanifi.siavash.iv1350.processSale.dbhandler.ItemDBHandler;
import hanifi.siavash.iv1350.processSale.externalSystemCommunication.HandleCreator;
import hanifi.siavash.iv1350.processSale.view.View;

/**
*Contains the <code>main</code> method. Performs all startup operations
*of the system.
*/
public class Main {

	 /**	
	 * Performs all startup operations of the system and executes the simulated cashier actions.
	 * @param args launch options set by the user, these have no effect on the program.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ItemDBHandler itemDBHandler = new ItemDBHandler();
		HandleCreator handleCreator = new HandleCreator();
		Controller controller = new Controller(itemDBHandler, handleCreator); //ParameterObject
		View view = new View(controller);
		view.sampleExecution();
	}

}
