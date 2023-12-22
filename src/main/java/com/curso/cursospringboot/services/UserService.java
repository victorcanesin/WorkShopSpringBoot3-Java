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
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		// get reference by id apenas monitora o registro, findbyId iria direto no banco buscar ele
		User entity = repository.getReferenceById(id);
		updateDada(entity, user);
		return repository.save(entity);
	}

	private void updateDada(User entity, User user) {
		entity.setName(user.getName());
		entity.setPhone(user.getPhone());
		entity.setEmail(user.getEmail());		
	}
}