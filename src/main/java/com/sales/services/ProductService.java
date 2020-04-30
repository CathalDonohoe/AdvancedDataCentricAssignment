package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pR;

	public ArrayList<Product> findAll() {
		return (ArrayList<Product>) pR.findAll();
	}

	// Saves the Product
	public Product save(Product p) {
		return pR.save(p);
	}
}
