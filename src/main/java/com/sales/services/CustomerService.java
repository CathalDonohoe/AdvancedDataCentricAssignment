package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository cR;

	public ArrayList<Customer> findAll() {
		return (ArrayList<Customer>) cR.findAll();
	}

	// Saves the customer
	public Customer save(Customer c) {
		return cR.save(c);
	}
}
