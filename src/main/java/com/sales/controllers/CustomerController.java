package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService cS;

	// Gets all items from Customers and displays them
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String getCustomers(Model m) {

		ArrayList<Customer> customers = (ArrayList<Customer>) cS.findAll();
		m.addAttribute("customers", customers);
		return "showCustomers";
	}

	// Adding a customer, Calls GetMethod
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String getAddCustomer(@ModelAttribute("customer") Customer customer, HttpServletRequest h) {
		return "addCustomer";
	}

	// Adding a customer, Calls PostMethod
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postAddCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		// enters if statement if errors exist
		if (result.hasFieldErrors()) {
			return "addCustomer";
		}
		// Saves our input and moves to the showCustomers.html
		else {
			cS.save(customer);
			return "redirect:showCustomers";
		}
	}
}
