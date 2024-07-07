package com.pharmacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.entity.Order;
import com.pharmacy.entity.User;
import com.pharmacy.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order saveOrder(Order order) {

		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrdersByUser(User user) {
		// TODO Auto-generated method stub
		return orderRepository.findByUser(user);
	}

	@Override
	public Order getOrderById(Integer orderId) {
		Optional<Order> findById = orderRepository.findById(orderId);
		if (findById.isPresent()) {
			Order order = findById.get();
			return order;
		}
		return null;
	}

}
