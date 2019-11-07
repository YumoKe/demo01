package com.bwei.beans;

public class MySort {

	private String price = "";
	
	private String cot = "";
	
	private String weight = "";

	private static MySort sort = new MySort();
	
	public static MySort getInstance(){
		return sort;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCot() {
		return cot;
	}

	public void setCot(String cot) {
		this.cot = cot;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "MySort [price=" + price + ", cot=" + cot + ", weight=" + weight + "]";
	}
	
	
}
