package com.marcel.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcel.workshopmongo.domain.Post;
import com.marcel.workshopmongo.domain.User;
import com.marcel.workshopmongo.repository.PostRepository;
import com.marcel.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User marcel = new User(null, "Marcel Bezerra", "marcel@gmail.com");
		User duda = new User(null, "Eduarda Aguiar", "duda@gmail.com");
		User brenda = new User(null, "Brenda Louise", "brenda@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("15/04/2019"), "Canada", "Estou me mudando pro Canada, tchau!", marcel);
		Post post2 = new Post(null, sdf.parse("16/04/2019"), "Cheguei!", "Chegamos bem, graças a Deus.", marcel);
		
		userRepository.saveAll(Arrays.asList(marcel, duda, brenda));
		postRepository.saveAll(Arrays.asList(post1, post2)); 
	}

}
