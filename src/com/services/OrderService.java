package com.services;

import java.util.List;

import com.dto.Order;

public interface OrderService {
	public List<Order> getAllOrders();
	public Order getOrderById(int id);
	public Order addOrder(Order o);
	public Order delOrder(int id);
	public Order updOrder(Order o);
	public int getMaxOrderid();
}
