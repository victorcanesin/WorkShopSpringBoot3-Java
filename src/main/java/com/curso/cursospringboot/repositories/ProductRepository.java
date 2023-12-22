package com.curso.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.cursospringboot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// fazendo a herança da classe jpaRepository ele ja vai ter quase todos os metodos para se manipular o banco de dados

}