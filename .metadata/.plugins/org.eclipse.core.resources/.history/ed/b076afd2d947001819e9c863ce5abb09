package com.ships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyRepository;




@Service
public class ShippingCompanyService {
//	Fields
	@Autowired
	public ShippingCompanyRepository shippingCompanyRepository;
	
	
	
	
//	Methods
	public Iterable<ShippingCompany> findAll() {
		return shippingCompanyRepository.findAll();
		
	}
	
} // end class ShipService