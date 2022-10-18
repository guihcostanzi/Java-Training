package entities;

public class Product {
	
	protected String name;
	protected Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String priceTag () {
		StringBuilder sb = new StringBuilder();
		
		sb.append("---- PRICE TAG | COMMON PRODUCT----" + '\n');
		sb.append("Name : " + name + '\n');
		sb.append("Price : $" + String.format("%.2f",price) + '\n');
		sb.append("-----------------------------------");
		
		
		return sb.toString();
	}

}


