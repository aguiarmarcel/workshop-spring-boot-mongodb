package com.marcel.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcel.workshopmongo.domain.User;
import com.marcel.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User marcel = new User(null, "Marcel Bezerra", "marcel@gmail.com");
		User duda = new User(null, "Eduarda Aguiar", "duda@gmail.com");
		User brenda = new User(null, "Brenda Louise", "brenda@gmail.com");
		
		userRepository.saveAll(Arrays.asList(marcel, duda, brenda));
	}

}
