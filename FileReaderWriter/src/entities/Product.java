package entities;

public class Product {
	
	private String name;
	private Double price;
	private Integer quantitySold;
	
	public Product(String name, Double price, Integer quantitySold) {
		this.name = name;
		this.price = price;
		this.quantitySold = quantitySold;
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
	
	public Integer getQuantitySold () {
		return quantitySold;
	}
	
	public double calculateTotalPrice () {
		return this.price * quantitySold;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", quantitySold=" + quantitySold +  "]";
	}
	
	
	
	

}
