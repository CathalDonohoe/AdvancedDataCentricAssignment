package com.sales.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class OrderController {

	@Autowired
	private OrderService oS;

	@Autowired
	private CustomerService cS;
	
	@Autowired
	private ProductService pS;

	// Gets all items from Orders and displays them
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getProducts(Model m) {

		ArrayList<Order> orders = (ArrayList<Order>) oS.findAll();
		m.addAttribute("orders", orders);
		return "showOrders";
	}

	// Adding a product, Calls GetMethod
	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String getAddOrder(Model m) {

		// Get Customers from DB
		ArrayList<Customer> customers = (ArrayList<Customer>) cS.findAll();
		// Create customerList Map
		Map<Long, String> customerList = new HashMap<Long, String>();

		// Add Customers to Map
		for (Customer c : customers) {
			customerList.put(c.getcId(), c.getcName());
		}

		// Add CustomerList to Model
		m.addAttribute("customerList", customerList);

		// Get Products from DB
		ArrayList<Product> products = (ArrayList<Product>) pS.findAll();
		// Create ProductList Map
		Map<Long, String> productList = new HashMap<Long, String>();

		// Add Products to Map
		for (Product p : products) {
			productList.put(p.getpId(), p.getpDesc());
		}

		// Add ProductList to Model
		m.addAttribute("productList", productList);

		// Creates new instance of order
		Order o = new Order();
		// add Order to the model
		m.addAttribute("Order", o);
		return "addOrder";

	}

	// Adding a product, Calls PostMethod
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String postAddOrder(@Valid @ModelAttribute("Order") Order order, BindingResult result) {
		// enters if statement if errors exist
		if (result.hasFieldErrors()) {
			return "addOrder";
		}
		// Saves our input and moves to the showOrders.html
		else {
			oS.save(order);
			return "redirect:showOrders";
		}
	}
}
