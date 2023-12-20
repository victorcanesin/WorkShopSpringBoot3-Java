package com.curso.cursospringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.cursospringboot.entities.Order;
import com.curso.cursospringboot.repositories.OrderRepository;

@Service // registra a class como componente do spring permitindo que ela seja autoinjetava no resource, no caso é especifico, o genérico é @Component
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	// aqui ja vai a injeção de dependencia do repository e podemos usar ele a vontade	
	
	public List<Order> findAll (){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}