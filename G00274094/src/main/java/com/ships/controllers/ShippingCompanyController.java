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

import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;




@SessionAttributes({"shipping_company","shipping_companies"})
@Controller
public class ShippingCompanyController {
//	Fields
	@Autowired
	private ShippingCompanyService shippingCompanyService;
	
	
	
	
	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String showShippingCompanies(Model model) {
		Iterable<ShippingCompany> shipping_companies = shippingCompanyService.findAll();
		model.addAttribute("shipping_companies", shipping_companies);
		
		return "showShippingCompanies";
		
	} // end showShips
	
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getShippingCompany(@ModelAttribute("companyAdd") ShippingCompany shippingCompany, HttpServletRequest h) {
		return "addShippingCompany";
	}// end getShippingCompany
	
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addShippingCompany(@Valid @ModelAttribute("companyAdd") ShippingCompany shippingCompany, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			return "addShippingCompany";
		} else {
			shippingCompanyService.save(shippingCompany);
			
			Iterable<ShippingCompany> shipping_companies = shippingCompanyService.findAll();
	
			m.addAttribute("shipping_companies", shipping_companies);
	
			return "showShippingCompanies";
		}
	}// end addShippingCompany
	
} // end class shipController