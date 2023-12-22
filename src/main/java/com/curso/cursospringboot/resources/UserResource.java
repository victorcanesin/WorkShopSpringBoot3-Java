package com.curso.cursospringboot.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.cursospringboot.entities.User;
import com.curso.cursospringboot.services.UserService;

@RestController // Informar que a class é um recurso web implementado por um controlador REST - é um conttroler
@RequestMapping(value="/users") // Da um nome para o recurso, informando o caminho o recurso, a entidade users
public class UserResource {

	@Autowired
	private UserService service;	
	
	// implementando metodo get
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
		// return ok é o codigo http e no corpo retorna o usuario
	}
	
	@GetMapping(value="/{id}") // indica que a url vai ter um parametro
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));	
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){		
		user = service.insert(user); // <--- aqui retorna o id 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
}