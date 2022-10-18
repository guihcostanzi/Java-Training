package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.ImportedProduct;
import entities.UsedProduct;
import enums.ProductCondition;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("-- PRODUCT REGISTER SYS --");
		System.out.println();

		System.out.print("How many products will you register ?");
		int quantity = sc.nextInt();
		sc.nextLine();
		System.out.println();

		Product[] productList = new Product[quantity];

		for (int i = 0; i < quantity; i++) {
			System.out.println("Let's register the #" + (i + 1) + " product :\n");

			System.out.print("Name : ");
			String name = sc.nextLine();

			System.out.print("Price : ");
			double price = sc.nextDouble();
			sc.nextLine();
			System.out.println();

			System.out.print("Is the product common, imported or used ? \n");
			System.out.println("1 - Common");
			System.out.println("2 - Used");
			System.out.println("3 - Imported");
			System.out.print("Type : ");
			int type = sc.nextInt();
			sc.nextLine();
			System.out.println();

			if (type == 1) {

				productList[i] = new Product(name, price);
			}

			else if (type == 2) {

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				System.out.print("Manufacture Date : ");
				Date date = sdf.parse(sc.next());
				sc.nextLine();
				System.out.print("Product State : ");
				ProductCondition state = ProductCondition.valueOf(sc.next());
				sc.nextLine();
				System.out.println();

				productList[i] = new UsedProduct(name, price, date, state);
			}

			else if (type == 3) {

				System.out.print("Custom's Fee : ");
				double customsFee = sc.nextDouble();
				sc.nextLine();
				System.out.println();
				
				System.out.print("Imported from : ");
				String originalCountry = sc.nextLine();
				System.out.println();

				productList[i] = new ImportedProduct(name, price, customsFee, originalCountry);
			}

			else {
				System.out.println("You didn't select a valid option. The registry was not made.");
			}

		}
		
		System.out.println("------- Price Tags -------");
		System.out.println();
		
		for (Product p : productList) {
			System.out.println(p.priceTag());
			System.out.println();
		}

		sc.close();

	}

}
