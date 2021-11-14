package entities;

public class ImportedProduct extends Product{
	private Double customFee;

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}
	
	public ImportedProduct() {
		super();
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	@Override
	public String priceTag() {
		return getName() + " $" + totalPrice() + " (Custom fee: $" + getCustomFee() + ")";
	}
	
	public double totalPrice() {
		return customFee + getPrice();
	}

	
	
}
