package com.ships.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderInfo {
	
	//Denotes primary key
	@Id
	//Auto generates Id
	@GeneratedValue
	//Contains Getters & Setters
	private int oid;
	
	//Defines a single-valued association to another entity class that has many-to-one multiplicity
	@ManyToOne
	//Specifies a column for joining an entity association 
	@JoinColumn(name="scid")
	//Contains Getters & Setters
	private ShippingCompany shippingCompany;
	
	//Defines a single-valued association to another entity that has one-to-one multiplicity
	@OneToOne
	//Specifies a column for joining an entity association 
	@JoinColumn(name="sid")
	//Contains Getters & Setters
	private Ship ship;
	
	//Contains Getters & Setters
	private String date;

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}
	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "OrderInfo [oid=" + oid + ", shippingCompany=" + shippingCompany + ", ship=" + ship + ", date=" + date
				+ "]";
	}
}
