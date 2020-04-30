package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository oR;

	// get current date and format it
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	public ArrayList<Order> findAll() {

		return (ArrayList<Order>) oR.findAll();
	}

	// Saves the Order
	public Order save(Order o) {
		o.setOrderDate(dateFormat.format(date));
		return oR.save(o);
	}
}
