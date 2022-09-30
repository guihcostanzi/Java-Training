package entities;

public class OrderItem {
	
	private int index;
	private Product product;
	private Integer quantity;
	private Double finalPrice = setFinalPrice();
	
	public OrderItem(int index, Product product, Integer quantity) {
		this.index = index;
		this.product = product;
		this.quantity = quantity;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	private Double setFinalPrice() {
		return product.getPrice()*quantity;
	}
	
	
	
	
}
