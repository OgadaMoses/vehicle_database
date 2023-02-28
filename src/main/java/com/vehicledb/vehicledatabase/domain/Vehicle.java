package com.vehicledb.vehicledatabase.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public Vehicle () {
		// default constructor with no arguments 
	}
	
	public Vehicle(String brand, String model, String color, String registerNumber, int vyear, int price, Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.vyear = vyear;
		this.price = price;
		this.owner = owner;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	
	public int getvYear() {
		return vyear;
	}
	public void setvYear(int year) {
		this.vyear = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String brand, model, color, registerNumber;
	private int vyear, price; 	


// Define relationship between Vehicle and Owner
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
private Owner owner;

public Owner getOwner() {
	return owner;
 }
public void setOwner(Owner owner) {
	this.owner = owner;
 }
  
}   	








