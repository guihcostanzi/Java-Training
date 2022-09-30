package Application;

import java.util.Scanner;

import Entities.Account;
import Util.AccountOperations;

public class Main {

	public static void main(String[] args) {
		System.out.println("Banck Account Management System :");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		System.out.println("Let's create your bank account :");
		System.out.println();

		System.out.println("Insert your name :");
		String name = sc.nextLine();

		System.out.println("Do you want to make an initial deposit ?");
		System.out.println(
				"Type :\n1 - If you do want to make an initial deposit.\n2 - If you don't want to make an initial deposit.");
		int option = sc.nextInt();
		
		String accountNumber = AccountOperations.generateAccountNumber();

		Account account;
		
		if (option == 1) {
			System.out.println("Insert the amount you want to deposit: ");
			double amount = sc.nextDouble();
			
			account = new Account(accountNumber, name, amount);
		}
		else {
			System.out.println("You choose to not make an initial deposit.");
			
			account = new Account(accountNumber, name);
		}
		
		System.out.println("Hold on a second. We are creating your account number...");
		
		
		System.out.println(account);
		
		sc.close();

	}

}
