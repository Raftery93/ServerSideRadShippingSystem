package com.ships.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.OrderRepository;
import com.ships.repositories.ShipRepository;
import com.ships.repositories.ShippingCompanyRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ShipRepository shipRepository;
	
	@Autowired
	private ShippingCompanyRepository companyRepository;
	
	@Autowired
	private ShipService shipService;
	
	private Ship ship;
	private ShippingCompany ShippingCompany;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	public Iterable<OrderInfo> findAll() {
		return orderRepository.findAll();
	}

	public OrderInfo saveOrder(OrderInfo order) {
		
		ship = shipRepository.findOne(order.getShip().getSid());
		ShippingCompany = companyRepository.findOne(order.getShippingCompany().getScid());
		
		ship.setShippingCompany(order.getShippingCompany());
		
		shipService.saveShip(ship);
		
		order.setShippingCompany(ShippingCompany);
		order.setDate(dateFormat.format(date));
		
		return orderRepository.save(order);
	}
}