package com.onetoonemappinng;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
	@Id
	private int id;
	private String brand;
	private String colour;
	private String model;
	private String modealYear;
	double price;
	
	@OneToOne
	private Engine engine;// 
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModealYear() {
		return modealYear;
	}
	public void setModealYear(String modealYear) {
		this.modealYear = modealYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", colour=" + colour + ", model=" + model + ", modealYear="
				+ modealYear + ", price=" + price + ", engine="+ engine +"]";
	}
	
}
