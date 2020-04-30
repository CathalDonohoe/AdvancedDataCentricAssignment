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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pS;

	// Gets all items from Products and displays them
	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String getProducts(Model m) {

		ArrayList<Product> products = (ArrayList<Product>) pS.findAll();
		m.addAttribute("products", products);
		return "showProducts";
	}

	// Adding a product, Calls GetMethod
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getAddProduct(@ModelAttribute("product") Product product, HttpServletRequest h) {
		return "addProduct";
	}

	// Adding a product, Calls PostMethod
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String postAddProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		// enters if statement if errors exist
		if (result.hasFieldErrors()) {
			return "addProduct";
		}
		// Saves our input and moves to the showProducts.html
		else {
			pS.save(product);
			return "redirect:showProducts";
		}
	}
}
