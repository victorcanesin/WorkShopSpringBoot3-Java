package com.curso.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.cursospringboot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	// fazendo a herança da classe jpaRepository ele ja vai ter quase todos os metodos para se manipular o banco de dados

}