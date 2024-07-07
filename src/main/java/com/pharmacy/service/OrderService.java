package com.pharmacy.service;

import java.util.List;

import com.pharmacy.entity.Order;
import com.pharmacy.entity.User;

public interface OrderService {

	public Order saveOrder(Order order);

	public List<Order> getOrdersByUser(User user);

	public Order getOrderById(Integer orderId);
}
