package com.ships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class SecurityController {
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(Model model) {

		
		return "logout";
		
	} // end showShips
	

} // end class shipController