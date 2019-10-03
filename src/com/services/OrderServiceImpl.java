package com.services;

import java.util.List;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.dto.Order;

public class OrderServiceImpl  implements OrderService{
 private OrderDao dao = new OrderDaoImpl();
 
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return dao.getAllOrders();
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return dao.getOrderById(id);
	}

	@Override
	public Order addOrder(Order o) {
		// TODO Auto-generated method stub
		return dao.addOrder(o);
	}

	@Override
	public Order delOrder(int id) {
		// TODO Auto-generated method stub
		return dao.delOrder(id);
	}

	@Override
	public Order updOrder(Order o) {
		// TODO Auto-generated method stub
		return dao.updOrder(o);
	}

	@Override
	public int getMaxOrderid() {
		// TODO Auto-generated method stub
		return dao.getMaxOrderid();
	}
	

}
