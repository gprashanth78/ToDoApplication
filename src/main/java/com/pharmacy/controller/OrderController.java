package com.pharmacy.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pharmacy.entity.Order;
import com.pharmacy.entity.Product;
import com.pharmacy.entity.User;
import com.pharmacy.service.OrderService;
import com.pharmacy.service.ProductService;
import com.pharmacy.service.UserService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@GetMapping("/create/{productId}")
	public String showOrderForm(@PathVariable("productId") Integer productId, Model model) {
		Product product = productService.getProductById(productId);
		Order order = new Order();
		order.setProduct(product);
		model.addAttribute("order", order);
		return "orderForm";
	}

	@PostMapping("/placeOrder")
	public String createOrder(@ModelAttribute("order") Order order, @AuthenticationPrincipal UserDetails userDetails) {
		User user = userService.findByEmail(userDetails.getUsername());
		order.setUser(user);
		order.setTime(new Date());
		order.setOrderStatus("Pending");
		orderService.saveOrder(order);
		return "redirect:/myOrders";
	}

	@GetMapping("/myOrders")
    public String viewMyOrders(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByEmail(userDetails.getUsername());
        List<Order> orders = orderService.getOrdersByUser(user);
        model.addAttribute("orders", orders);
        return "orderList";
    }
	
	@GetMapping("/viewOrders/{orderId}")
    public String viewOrderDetails(@PathVariable("orderId") Integer orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "orderDetails";
    }
}
