package com.curso.cursospringboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.cursospringboot.entities.Product;
import com.curso.cursospringboot.services.ProductService;

@RestController // Informar que a class é um recurso web implementado por um controlador REST - é um conttroler
@RequestMapping(value="/products") // Da um nome para o recurso, informando o caminho o recurso, a entidade Products
public class ProductResource {

	@Autowired
	private ProductService service;	
	
	// implementando metodo get
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
		// return ok é o codigo http e no corpo retorna o usuario
	}
	
	@GetMapping(value="/{id}") // indica que a url vai ter um parametro
	public ResponseEntity<Product> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));	
	}
	
}