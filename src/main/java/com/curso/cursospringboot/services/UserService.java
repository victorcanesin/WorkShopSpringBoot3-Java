package com.curso.cursospringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.cursospringboot.entities.User;
import com.curso.cursospringboot.repositories.UserRepository;

@Service // registra a class como componente do spring permitindo que ela seja autoinjetava no resource, no caso é especifico, o genérico é @Component
public class UserService {
	
	@Autowired
	private UserRepository repository;
	// aqui ja vai a injeção de dependencia do repository e podemos usar ele a vontade	
	
	public List<User> findAll (){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
}