package hanifi.siavash.iv1350.processSale.view;

import hanifi.siavash.iv1350.processSale.model.Sale;
import hanifi.siavash.iv1350.processSale.model.Tax;
import hanifi.siavash.iv1350.processSale.model.TotalRevenueAdapter;

/**
 * Represents the total revenue from a series of sales.
 * @author Siavash
 *
 */
public class TotalRevenue extends TotalRevenueAdapter{
	double totalRevenue = 0;
	
	private double totalRevenueCalculator(Sale sale, Tax tax) {
		return sale.getRunningTotal() - tax.getTaxAmount() + this.totalRevenue;
	}
	
	private void setTotalRevenue(Sale sale){
		Tax tax = new Tax(sale);
		this.totalRevenue = totalRevenueCalculator(sale, tax) ;
	}
	
	public double getTotalRevenue() {
		return this.totalRevenue;
	}

	@Override
	public void saleHasBeenCompleted(Sale sale) {
		setTotalRevenue(sale);
	}
	
	
}
