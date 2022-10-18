package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.ProductCondition;

public final class UsedProduct extends Product {
	
	private Date manufactureDate;
	private ProductCondition condition;

	public UsedProduct(String name, Double price, Date manufactureDate, ProductCondition condition) {
		super(name, price);
		this.manufactureDate = manufactureDate;
		this.condition = condition;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	public ProductCondition getCondition() {
		return condition;
	}

	public void setCondition(ProductCondition condition) {
		this.condition = condition;
	}
	
	private String formatedCondition () {
		if (this.condition == ProductCondition.BAD_CONDITION) {
			return "Bad Condition";
		}
		else if (this.condition == ProductCondition.GOOD_CONDITION) {
			return "Good Condition";
		}
		else {
			return "Perfect Condition";
		}
	}

	@Override
	public String priceTag () {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		
		sb.append("---- PRICE TAG | USED PRODUCT ----" + '\n');
		sb.append("Name : " + name + '\n');
		sb.append("Price : $" + String.format("%.2f",price) + '\n');
		sb.append("Manufacture Date : " + sdf.format(manufactureDate) + '\n' );
		sb.append("Product Condition : " + formatedCondition() + "\n");
		sb.append("----------------------------------");
		
		return sb.toString();
	}
	
	

}
