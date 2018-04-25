package com.ships.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ship {
	
	//Denotes primary key
	@Id
	//Auto generates Id
	@GeneratedValue
	//Contains Getters & Setters
	private Long sid;
	
	//Cannot be null
	@NotNull
	//Size must be between 1-250
    @Size(min=1,max=250)
	//Contains Getters & Setters
	private String name;
	
	//Cannot be less than 0
	@Min(value = 0)
	//Contains Getters & Setters
	private int passengers;
	
	//Cannot be null
	@NotNull
	//Contains Getters & Setters
	private BigDecimal cost;
	
	//Cannot be less than 1
	@Min(value = 1)
	//Contains Getters & Setters
	private double metres;
	
	//Defines a single-valued association to another entity class that has many-to-one multiplicity
	@ManyToOne
	//Specifies a column for joining an entity association 
	@JoinColumn(name="scid")
	//Contains Getters & Setters
	private ShippingCompany shippingCompany;
		
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public double getMetres() {
		return metres;
	}
	public void setMetres(double metres) {
		this.metres = metres;
	}
	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}
	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	@Override
	public String toString() {
		return name + ", ";
	}	
	
}
