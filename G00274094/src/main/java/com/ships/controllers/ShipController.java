package com.ships.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ships.model.Ship;
import com.ships.services.ShipService;




@SessionAttributes({"ship","ships"})
@Controller
public class ShipController {
//	Fields
	@Autowired
	private ShipService shipService;
	
	
	
	
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String showShips(Model model) {
		Iterable<Ship> ships = shipService.findAll();
		model.addAttribute("ships", ships);
		
		return "showShips";
		
	} // end showShips
	
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("shipAdd") Ship c, HttpServletRequest h) {
		return "addShip";
	}// end getShip
	
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("shipAdd") Ship ship, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			return "addShip";
		} else {
			shipService.saveShip(ship);
			
			Iterable<Ship> ships = shipService.findAll();
	
			m.addAttribute("ships", ships);
	
			return "showShips";
		}
	}// end addShip
	
} // end class shipController