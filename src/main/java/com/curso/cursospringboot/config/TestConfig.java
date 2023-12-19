package com.curso.cursospringboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.cursospringboot.entities.User;
import com.curso.cursospringboot.repositories.UserRepository;

@Configuration
@Profile("test") // indica que a configuração roda apenas no perfil de test - nome que esta no application.properties
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	// com isso o spring ja entende que ele deve criar uma instancia do repository

	@Override
	public void run(String... args) throws Exception {
		// tudo incluido nesse metodo sera executado quando a aplicacao for iniciada
		// incluido pela implementacao da interface CommandLineRunner
		
		User user1 = new User(null, "victor canesin", "victor@email.com","651513451", "pasewwsd#!@#" );
		User user2 = new User(null, "pc garcia", "pc_garcia@email.com","6151154151", "pasewwsfddfd#!@#" );
		
		userRepository.saveAll(Arrays.asList(user1, user2)); // salva no banco de dados
	}
	
	
}