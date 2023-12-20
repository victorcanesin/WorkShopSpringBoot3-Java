package com.curso.cursospringboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.cursospringboot.entities.Category;
import com.curso.cursospringboot.services.CategoryService;

@RestController // Informar que a class é um recurso web implementado por um controlador REST - é um conttroler
@RequestMapping(value="/categories") // Da um nome para o recurso, informando o caminho o recurso, a entidade users
public class CategoryResource {

	@Autowired
	private CategoryService service;	
	
	// implementando metodo get
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
		// return ok é o codigo http e no corpo retorna o usuario
	}
	
	@GetMapping(value="/{id}") // indica que a url vai ter um parametro
	public ResponseEntity<Category> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));	
	}
	
}