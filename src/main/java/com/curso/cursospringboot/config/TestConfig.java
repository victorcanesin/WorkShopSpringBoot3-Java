package com.curso.cursospringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.cursospringboot.entities.Category;
import com.curso.cursospringboot.entities.Order;
import com.curso.cursospringboot.entities.OrderItem;
import com.curso.cursospringboot.entities.Product;
import com.curso.cursospringboot.entities.User;
import com.curso.cursospringboot.entities.enums.OrderStatus;
import com.curso.cursospringboot.repositories.CategoryRepository;
import com.curso.cursospringboot.repositories.OrderItemRepository;
import com.curso.cursospringboot.repositories.OrderRepository;
import com.curso.cursospringboot.repositories.ProductRepository;
import com.curso.cursospringboot.repositories.UserRepository;

@Configuration
@Profile("test") // indica que a configuração roda apenas no perfil de test - nome que esta no
					// application.properties
public class TestConfig implements CommandLineRunner {

	@Autowired // com isso o spring ja entende que ele deve criar uma instancia do repository
	private UserRepository userRepository;

	@Autowired // com isso o spring ja entende que ele deve criar uma instancia do repository
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		// tudo incluido nesse metodo sera executado quando a aplicacao for iniciada
		// incluido pela implementacao da interface CommandLineRunner

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // salva no banco de dados

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		Product p6 = new Product(null, "MONITOR", "MONITOR 23' FHD", 975.0, "");
		Product p7 = new Product(null, "MONITOR", "MONITOR 27' WQHD", 1800.0, "");
		Product p8 = new Product(null, "MONITOR", "MONITOR 34' WQHD", 2900.0, "");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
		
		// salvar categories
		p1.getCategory().add(cat2);
		p2.getCategory().add(cat1);
		p2.getCategory().add(cat3);
		p3.getCategory().add(cat3);
		p4.getCategory().add(cat3);
		p5.getCategory().add(cat2);
		p6.getCategory().add(cat1);
		p7.getCategory().add(cat1);
		p8.getCategory().add(cat1);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));

		User user1 = new User(null, "victor canesin", "victor@email.com", "651513451", "pasewwsd#!@#");
		User user2 = new User(null, "pc garcia", "pc_garcia@email.com", "6151154151", "pasewwsfddfd#!@#");

		userRepository.saveAll(Arrays.asList(user1, user2)); // salva no banco de dados

		Order o1 = new Order(null, Instant.parse("2023-12-20T19:53:07Z"), user1, OrderStatus.CANCELADO);
		Order o2 = new Order(null, Instant.parse("2023-12-21T03:42:10Z"), user2, OrderStatus.ENTREGUE);
		Order o3 = new Order(null, Instant.parse("2023-12-22T15:21:22Z"), user1, OrderStatus.AGUARDANDO_PAGAMENTO);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // salva no banco de dados
		
		OrderItem oi1 = new OrderItem(o1, p1, 2.0, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1.0, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2.0, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2.0, p5.getPrice()); 

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}

}