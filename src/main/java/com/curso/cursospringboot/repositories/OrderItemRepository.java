package com.curso.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.cursospringboot.entities.OrderItem;
import com.curso.cursospringboot.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	
	// fazendo a herança da classe jpaRepository ele ja vai ter quase todos os metodos para se manipular o banco de dados

}