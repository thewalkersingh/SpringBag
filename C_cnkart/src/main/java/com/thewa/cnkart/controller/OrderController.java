package com.thewa.cnkart.controller;

import com.thewa.cnkart.entity.Order;
import com.thewa.cnkart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	@Autowired
	OrderService orderService;

	@GetMapping("/id/{id}")
	public Order getItemById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}

	@PostMapping("/save")
	public void saveItem(@RequestBody Order order) {
		orderService.saveOrder(order);
	}

	@GetMapping("/getAll")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteOrder(@PathVariable int id) {
		orderService.deleteOrderById(id);
	}

	@PutMapping("/update")
	public void updateOrder(@RequestBody Order order, BindingResult bindingResult) {
		orderService.updateOrder(order);
	}
}