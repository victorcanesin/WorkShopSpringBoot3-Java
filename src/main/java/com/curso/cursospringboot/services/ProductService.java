package com.curso.cursospringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.cursospringboot.entities.Product;
import com.curso.cursospringboot.repositories.ProductRepository;

@Service // registra a class como componente do spring permitindo que ela seja autoinjetava no resource, no caso é especifico, o genérico é @Component
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	// aqui ja vai a injeção de dependencia do repository e podemos usar ele a vontade	
	
	public List<Product> findAll (){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}