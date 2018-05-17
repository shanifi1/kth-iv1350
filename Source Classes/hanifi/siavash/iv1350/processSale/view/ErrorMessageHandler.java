package hanifi.siavash.iv1350.processSale.view;

import java.util.Date;

/**
 * Used to notify the cashier about occurred program failures.
 * @author Siavash
 *
 */
class ErrorMessageHandler {
	private Date date;
	/**
	* Displays the specified error message.
	* @param msg The error message.
	*/
	void showErrorMsg(String msg) {
		date = new Date();
		StringBuilder errorMsgBuilder = new StringBuilder();
		errorMsgBuilder.append("********************CASHIER NOTIFICATION********************");
		errorMsgBuilder.append(System.getProperty("line.separator"));
		errorMsgBuilder.append(date.toString());
		errorMsgBuilder.append(", ERROR: ");
		errorMsgBuilder.append(msg);
		errorMsgBuilder.append(System.getProperty("line.separator"));
		errorMsgBuilder.append("****************END OF CASHIER NOTIFICATION*****************");
		errorMsgBuilder.append(System.getProperty("line.separator"));
		System.out.println(errorMsgBuilder);
	}
}
