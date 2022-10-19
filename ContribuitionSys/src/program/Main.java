package program;

import java.util.Locale;
import java.util.Scanner;

import entities.JuridicalPerson;
import entities.Person;
import entities.PhysicalPerson;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("-- Contribuition Sys --");
		System.out.println();
		
		System.out.println("How many tax payers ?");
		int taxPayers = sc.nextInt();
		sc.nextLine();
		
		Person [] personsList = new Person [taxPayers];
		
		for (int i = 0; i < taxPayers; i++) {
			System.out.println("Tax Payer #" + (i+1) + " data :");
			System.out.print("Physical or Juridical Person (p/j) ?");
			char option = sc.next().charAt(0);
			sc.nextLine();
			System.out.println();
			
			System.out.print("Name : ");
			String name = sc.nextLine();
			
			System.out.print("Annual Revenue ($) : ");
			Double aRevenue = sc.nextDouble();
			sc.nextLine();
			
			if (option == 'p') {
				
				System.out.print("CPF : ");
				String cpf = sc.next();
				sc.nextLine();
				
				System.out.print("Health Expenses ($) : ");
				Double hExpenses = sc.nextDouble();
				sc.nextLine();
				
				personsList[i] = new PhysicalPerson(name, aRevenue, cpf, hExpenses);
			}
			
			else if (option == 'j') {
				
				System.out.print("CNPJ : ");
				String cnpj = sc.next();
				sc.nextLine();
				
				System.out.print("Exployee Number : ");
				int eNumber = sc.nextInt();
				sc.nextLine();
				
				personsList[i] = new JuridicalPerson(name, aRevenue, cnpj, eNumber);
			}
		}
		
		Double taxTotal = 0.0;
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("TAXES PAID : \n");

		for (Person p : personsList) {
			System.out.println("-" + p.getName() + ": $ " + String.format("%.2f", p.calculateTax()));
			taxTotal += p.calculateTax();
		}
		
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("TAXES TOTAL : $ " + String.format("%.2f", taxTotal));
		
		sc.close();
	}

}
