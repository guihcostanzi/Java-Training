package Application;

import java.util.Locale;
import java.util.Scanner;

import Util.CurrencyConverter;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Currency Exchange Project:");
		System.out.println();
		
		System.out.println("How much currency do you want to exchange for USD ?");
		double currencyTotalValue = sc.nextDouble();
		System.out.println("How much is the dollar quotation ?");
		double usdQuotation = sc.nextDouble();
		
		System.out.println("The final dollar amount you got is composed by the total value of your currency, divided by the current dollar quotation, minus the IOF tax, which is 6 percent.");
		System.out.println();
		System.out.println("USD Total : $" + String.format("%.2f",CurrencyConverter.ToDollar(currencyTotalValue, usdQuotation)));
		
		System.out.println();
		System.out.println("How much USD do you want to buy ?");
		currencyTotalValue = sc.nextDouble();
		System.out.println("How much is the dollar quotation ?");
	    usdQuotation = sc.nextDouble();
	    
	    System.out.println("The price you're paying is composed by the USD quantity you are buying multiplied by the current dollar quotation, plus the IOF tax, which is 6 percent. ");
		System.out.println();
		System.out.printf("How much you need to pay : %.2f of the currency being negociated.\n", CurrencyConverter.buyDollar(currencyTotalValue, usdQuotation));
		
		System.out.println("\nThank you. It was a pleasure negotiating with you.");
		
		sc.close();
		
	}

}
