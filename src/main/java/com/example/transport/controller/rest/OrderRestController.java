package com.example.transport.controller.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.transport.model.Order;
import com.example.transport.repository.CustomOrderRepository;
import com.example.transport.repository.OrderRepository;

@RestController
public class OrderRestController {

	@Autowired
	private OrderRepository repository; 
	@Autowired
	private CustomOrderRepository customRepository;

	@GetMapping("/orders")
	public Iterable<Order> getOrders() {
		return repository.findAll();
	}

	@PostMapping("/orders")
	public void addOrder(@RequestBody Order newOrder) {
		
		double distance = customRepository.calculate(newOrder.getSourceAddress(), newOrder.getDestinationAddress());
		newOrder.setDistance(distance);
		repository.save(newOrder);
	}
	
	@PutMapping("/orders")
	public Order updateOrder(@RequestBody Order theOrder) {
		repository.save(theOrder);
		
		return theOrder;
	}
	
	@DeleteMapping("/orders/{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		
		repository.deleteById(orderId);
	}

	@GetMapping("/orders/{orderId}")
	public Optional<Order> getOrder(@PathVariable Long orderId) {

		Optional<Order> order = repository.findById(orderId);

		// if(theOrder == null) {
		// throw new OrderNotFoundException("Order id not found - " + orderId);
		// }
		return order;
	}

	
	@GetMapping("/test")
	public ModelAndView order() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("order");
		return modelAndView;
	}
}
