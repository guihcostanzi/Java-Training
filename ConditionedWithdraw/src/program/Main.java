package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.CustomLogicalException;

public class Main {

	public static void main(String[] args) {

		// Programa para treinar Tratamento de Exceções;

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Let's create you account.");
			System.out.print("Holder's Name : ");
			String holder = sc.nextLine();
			System.out.println();

			Date birthDate = null;
			do {
				System.out.print("Holder's Birthdate (dd/MM/yyyy) : ");
				birthDate = sdf.parse(sc.next());
				sc.nextLine();
			} while (birthDate == null);
			System.out.println();

			System.out.print("Account's Withdraw Limit : ");
			double wLimit = sc.nextDouble();
			sc.nextLine();
			System.out.println();

			Account acc = new Account(holder, birthDate, wLimit);
			System.out.println("Your account was created !\n");
			System.out.println(acc.toString());

			System.out.println("Make your first deposit to start using you account !");
			System.out.print("Initial deposit : ");
			acc.depositMoney(sc.nextDouble());
			sc.nextLine();

			System.out.println(acc.toString());

			System.out.println("Now make your first withdraw !");
			System.out.print("Withdraw value : ");
			acc.withdrawMoney(sc.nextDouble());
			sc.nextLine();

			System.out.println(acc.toString());

			System.out.println("Do you want to make another operation ? y/n");
			char option = sc.next().charAt(0);
			sc.nextLine();

			if (option == 'y') {
				
				while (option == 'y') {
					System.out.println("Withdraw or Deposit ? w/d");
					option = sc.next().charAt(0);
					sc.nextLine();

					if (option == 'w') {
						System.out.print("How much ?");
						acc.withdrawMoney(sc.nextDouble());
						System.out.println();
						sc.nextLine();
					} else if (option == 'd') {
						System.out.print("How much ?");
						acc.depositMoney(sc.nextDouble());
						System.out.println();
						sc.nextLine();
					} else {
						System.out.println("You didn't select a valid option.");
					}
					
					System.out.println(acc.toString());

					System.out.println("Do you want to make another operation ? y/n");
					option = sc.next().charAt(0);
					sc.nextLine();
				}
				
			System.out.println("Volte sempre !");

			}

		} 
		catch (CustomLogicalException e) {
			System.out.println("Ilegal action : " + e.getMessage());
		} 
		catch (ParseException e) {
			System.out.println("Invalid Date : Birthdate not registered.");
		} 
		catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		finally {
			if (sc != null) {
				sc.close();
				System.out.println("Atendimento encerrado.");
			}
		}
		

		

	}

}
