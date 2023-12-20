package com.curso.cursospringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.cursospringboot.entities.Category;
import com.curso.cursospringboot.repositories.CategoryRepository;

@Service // registra a class como componente do spring permitindo que ela seja autoinjetava no resource, no caso é especifico, o genérico é @Component
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	// aqui ja vai a injeção de dependencia do repository e podemos usar ele a vontade	
	
	public List<Category> findAll (){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}