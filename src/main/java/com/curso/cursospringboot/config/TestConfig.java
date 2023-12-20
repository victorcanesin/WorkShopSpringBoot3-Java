package com.curso.cursospringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.cursospringboot.entities.Category;
import com.curso.cursospringboot.entities.Order;
import com.curso.cursospringboot.entities.User;
import com.curso.cursospringboot.entities.enums.OrderStatus;
import com.curso.cursospringboot.repositories.CategoryRepository;
import com.curso.cursospringboot.repositories.OrderRepository;
import com.curso.cursospringboot.repositories.UserRepository;

@Configuration
@Profile("test") // indica que a configuração roda apenas no perfil de test - nome que esta no application.properties
public class TestConfig implements CommandLineRunner {
	
	@Autowired 	// com isso o spring ja entende que ele deve criar uma instancia do repository
	private UserRepository userRepository;
	
	@Autowired 	// com isso o spring ja entende que ele deve criar uma instancia do repository
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		// tudo incluido nesse metodo sera executado quando a aplicacao for iniciada
		// incluido pela implementacao da interface CommandLineRunner
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3)); // salva no banco de dados

		
		User user1 = new User(null, "victor canesin", "victor@email.com","651513451", "pasewwsd#!@#" );
		User user2 = new User(null, "pc garcia", "pc_garcia@email.com","6151154151", "pasewwsfddfd#!@#" );
		
		userRepository.saveAll(Arrays.asList(user1, user2)); // salva no banco de dados
		
		Order o1 = new Order(null, Instant.parse("2023-12-20T19:53:07Z"), user1, OrderStatus.CANCELADO);
		Order o2 = new Order(null, Instant.parse("2023-12-21T03:42:10Z"), user2, OrderStatus.ENTREGUE);
		Order o3 = new Order(null, Instant.parse("2023-12-22T15:21:22Z"), user1, OrderStatus.AGUARDANDO_PAGAMENTO); 
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // salva no banco de dados
	}
	
	
}