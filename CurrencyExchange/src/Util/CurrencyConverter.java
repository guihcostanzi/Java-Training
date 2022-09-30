package Util;

public class CurrencyConverter {

	public static final double IOF = 0.06;

	public static double ToDollar(double currencyTotalValue,double usdQuotation ) {
		
		return (currencyTotalValue / usdQuotation) - (currencyTotalValue / usdQuotation) * IOF;			
	}

public static double buyDollar(double usdTotalValue, double usdQuotation ) {	
		
		return (usdTotalValue * usdQuotation) + (usdTotalValue * usdQuotation) * IOF;			
	}

}
