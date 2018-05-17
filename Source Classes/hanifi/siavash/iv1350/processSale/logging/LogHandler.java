package hanifi.siavash.iv1350.processSale.logging;

import java.util.Date;
/**
 * This class is responsible for the log.
 * @author Siavash
 *
 */
public class LogHandler { /*ADDED FOR SEMINAR 4*/
	private Date date;
	/**
	 * Writes a log entry describing a thrown exception.
 	 *@param exception The exception that shall be logged.
	 * 
	 */
	public void logException(Exception exception) {
		date = new Date();
		StringBuilder logMsgBuilder = new StringBuilder();
		System.out.println("********************LOG********************");
		logMsgBuilder.append(date.toString());
		logMsgBuilder.append(", Exception was thrown: ");
		logMsgBuilder.append(exception.getMessage());
		System.out.println(logMsgBuilder);
		exception.printStackTrace(System.out);
		System.out.println("****************END OF LOG*****************");
		System.out.println();
	}
}
