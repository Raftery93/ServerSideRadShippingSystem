package com.ships.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.OrderService;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ShipService shipService;
	
	@Autowired
	private ShippingCompanyService companyService;
	
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getShips(Model m) {

		Iterable<OrderInfo> orders = orderService.findAll();
		m.addAttribute("orders", orders);

		return "showOrders";
	}
		
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("orderAdd") OrderInfo order, HttpServletRequest h, Model m) {
		
		Iterable<Ship> ships = shipService.findAll();
		
		Map<Long,String> shipList = new HashMap<Long,String>();
		
		for (Ship s : ships) {
			if (s.getShippingCompany() == null){
				shipList.put(s.getSid(), s.getName() + ", Cost = " + s.getCost());
			}
		}
		
		m.addAttribute("shipList", shipList);
		
		
		Iterable<ShippingCompany> companies = companyService.findAll();
		
		Map<Long,String> companyList = new HashMap<Long,String>();
		
		//ShippingCompany shipC;
		//Ship ship = null;
		
		for (ShippingCompany sc : companies) {	
			companyList.put(sc.getScid(), sc.getName() + ", Balance = " + sc.getBalance());
		}
		
		m.addAttribute("companyList", companyList);
		
		/*
		if(shipC.getBalance().compareTo(ship.getCost()) < 0) {
			
		}
		*/
		
		return "createOrder";
	}
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("orderAdd") OrderInfo order, BindingResult result, HttpServletRequest h, Model m) {
		
		if(order.getShip() == null || order.getShippingCompany() == null) {
			return "ErrorOrderSelected";
		} else if(order.getShip().getCost().compareTo(order.getShippingCompany().getBalance())>0){
		
			return "errorOrderFunds";
			
		}else {
		
			order.getShippingCompany().setBalance(order.getShippingCompany().getBalance().subtract(order.getShip().getCost()));
			
			orderService.saveOrder(order);
			shipService.saveShip(order.getShip());
			
			
			Iterable<OrderInfo> orders = orderService.findAll();
			m.addAttribute("orders", orders);
			
	
			return "showOrders";
		}
	}
}