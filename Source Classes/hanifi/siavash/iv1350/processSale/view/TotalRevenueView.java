package hanifi.siavash.iv1350.processSale.view;

import hanifi.siavash.iv1350.processSale.model.Sale;
import hanifi.siavash.iv1350.processSale.model.SaleObserver;
import hanifi.siavash.iv1350.processSale.model.Tax;
import hanifi.siavash.iv1350.processSale.model.TotalRevenueAdapter;
/**
 * The user interface presenting information about the total revenue since the program started.
 * @author Siavash
 *
 */
public class TotalRevenueView implements SaleObserver {
	private double totalRevenue = 0;
	private int saleCounter = 0;
	
	private void presentTotalRevenue() {
		System.out.println("******************************");
		System.out.println("Total revenue today: " + this.totalRevenue);
		System.out.println("******************************");
	}
	
	/**
	 * the total revenue of an ongoing series of sales.
	 */
	private double totalRevenueCalculator(Sale sale) {
		return sale.getRunningTotal() + this.totalRevenue;
	}
	
	private void setTotalRevenue(Sale sale){
		this.totalRevenue = totalRevenueCalculator(sale) ;
	}

	/**
	 * Updates the UI showing the total revenue since the program started
	 */
	@Override
	public void saleHasBeenCompleted(Sale sale) {
		setTotalRevenue(sale);
		saleCounter++;
		presentTotalRevenue();
	}
}
