package com.gacamargo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gacamargo.workshopmongo.domain.Post;
import com.gacamargo.workshopmongo.domain.User;
import com.gacamargo.workshopmongo.dto.AuthorDTO;
import com.gacamargo.workshopmongo.repository.UserRepository;
import com.gacamargo.workshopmongo.repository.postRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private postRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, "Partiu viajem!",  "Vou viajar pra São Paulo. Abraços!", sdf.parse("21/03/2018"), new AuthorDTO(maria));
		Post post2 = new Post(null, "Bom dia!", "Acordei feliz hoje!", sdf.parse("23/03/2018"), new AuthorDTO(maria));
		
		postRepo.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
