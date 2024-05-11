package model;

public class Product {
	private String name;
	private int price;
	private String updated;
	
	
	public Product(){}
	
	public Product(String name, int price, String update){
		this.name  =name;
		this.price  =price;
		this.updated  =updated;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getUpdated() {
		return updated;
	}
	
}
