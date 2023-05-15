package com.exterro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long carId;
	private String regNo;
	private String model;
	private String owner;
	private double cost;
	public Car() {
		super();
	}
	public Car(String regNo, String model, String owner, double cost) {
		super();
		this.regNo = regNo;
		this.model = model;
		this.owner = owner;
		this.cost = cost;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public long getCarId() {
		return carId;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", regNo=" + regNo + ", model=" + model + ", owner=" + owner + ", cost=" + cost
				+ "]";
	}	
}
