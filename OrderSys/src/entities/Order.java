package entities;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import enums.OrderStatus;

public class Order {
	private Instant date = setDate();
	private String adress;
	private Customer customer;
	private List<OrderItem> orderItens = new ArrayList<>();
	private OrderStatus status;
	
	public Order(String adress, Customer customer, OrderStatus status) {
		this.adress = adress;
		this.customer = customer;
		this.status = status;
	}

	public Instant getDate() {
		return date;
	}

	public Instant setDate() {
		return Instant.now();	
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Customer getCoutumer() {
		return customer;
	}

	public void setCustumer(Customer customer) {
		this.customer = customer;
	}
	
	public void addOrderItem (OrderItem orderItem) {
		orderItens.add(orderItem);
	}
	
	public void removeOrderItem (OrderItem orderItem) {
		orderItens.remove(orderItem);
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH/mm");
		
		
		sb.append("ORDER SUMMARY : \n");
		sb.append("-------------\n");
		sb.append("Moment : " + dtf.format(date) + "\n");
		sb.append("Status : " + status + "\n");
		sb.append("-------------\n");
		sb.append("Customer Data :\n");
		sb.append("Name : " + customer.getName());
		sb.append("Age : " + customer.getAge());
		sb.append("Gender : " + customer.getGender());
		sb.append("-------------\n");
		
		double total = 0;
		
		for ( OrderItem c : orderItens) {
			sb.append("Order Item #" + c.getIndex() + " :\n");
			sb.append("x" + c.getQuantity() + " " + c.getProduct().getName() + " = " + String.format("%.2f", c.getFinalPrice()));
			
			total += c.getFinalPrice();
		}
		
		sb.append("Final Bill : $" + String.format("%.2f",total) );
		
		return sb.toString();
	}

}