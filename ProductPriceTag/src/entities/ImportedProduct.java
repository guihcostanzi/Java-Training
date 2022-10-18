package entities;

public final class ImportedProduct extends Product {
	
	private Double customsFee;
	private String originalCountry;

	public ImportedProduct(String name, Double price, Double customsFee, String originalCountry) {
		super(name, price);
		this.customsFee = customsFee;
		this.originalCountry = originalCountry;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public String getOriginalCountry() {
		return originalCountry;
	}

	public void setOriginalCountry(String originalCountry) {
		this.originalCountry = originalCountry;
	}

	public Double TotalPrice() {
		return price + customsFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder ();
		
		sb.append("---- PRICE TAG | IMPORTED PRODUCT ----" + '\n');
		sb.append("Name : " + name + '\n');
		sb.append("Base Price : $" + String.format("%.2f",price) + '\n');
		sb.append("Custom's Fee : $" + String.format("%.2f",customsFee) + '\n');
		sb.append("Total Price : $" + String.format("%.2f",TotalPrice()) + '\n');
		sb.append("Made In : " + originalCountry + '\n');
		sb.append("--------------------------------------\n");
		
		return sb.toString();
	}
	
	
	
}
