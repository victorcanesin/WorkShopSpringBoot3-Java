package com.curso.cursospringboot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.cursospringboot.entities.User;

@RestController // Informar que a class é um recurso web implementado por um controlador REST - é um conttroler
@RequestMapping(value="/users") // Da um nome para o recurso, informando o caminho o recurso, a entidade users
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "victor", "victor@email.com", "999999999", "senhaX");
		return ResponseEntity.ok().body(user);
		// return ok é o codigo http e no corpo retorna o usuario
	}
	
}