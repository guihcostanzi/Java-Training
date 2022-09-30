package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Customer;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Order System :");
		System.out.println();
		
		System.out.println("Enter Costumer Data : ");
		System.out.println();
		
		System.out.println("Name :");
		String name = sc.nextLine();
		
		System.out.println("Gender (F/M) :");
		char gender = sc.next().charAt(0);
		
		//Receiving a date;
				
		System.out.println("Birth Date (dd/MM/yyyy) :");
		Date birthDate = sdf.parse(sc.next());
		
		System.out.println("E-mail :");
		String email = sc.next();
		
		Customer costumer = new Customer(name, birthDate, email, gender);
		
		System.out.println("Enter Order Data :");
		System.out.println();
		
		System.out.println("Status :");
		String text = sc.next();
		sc.nextLine();
		OrderStatus status = OrderStatus.valueOf(text);
		
		System.out.println("Adress :");
		String adress = sc.nextLine();
		
		Order order = new Order(adress, costumer, status);
		
		System.out.println("How many itens to this order ? :");
		int quantityOrderItens = sc.nextInt();
		
		for (int i = 0; i < quantityOrderItens ; i++) {
			sc.nextLine();
			System.out.println("Enter Order Item number #" + (i+1) + " data :");
			System.out.println("Name :");
			name = sc.nextLine();
			System.out.println("Price :");
			double price = sc.nextDouble();
			
			Product product = new Product(name, price);
			
			System.out.println("Quantity :");
			Integer quantity = sc.nextInt();
			
			int index = i + 1;
			
			OrderItem orderItem = new OrderItem(index, product, quantity);
			
			order.addOrderItem(orderItem);
		}
		
		System.out.println(order.toString());
		sc.close();
	}

}
