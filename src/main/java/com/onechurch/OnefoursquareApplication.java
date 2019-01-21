package com.onechurch;

import com.onechurch.process.config.security.PasswordEncoder;
import com.onechurch.process.domain.User;
import com.onechurch.process.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * RESTful API HATEOAS - Hypermedia AS the Engine of Application State:
 * 1) service should provide navigation data
 * 2) documentation
 * 3) Hypermedia driven out of box
 */
@SpringBootApplication
public class OnefoursquareApplication implements CommandLineRunner{

	@Autowired
	private UserServiceImpl userServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(OnefoursquareApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		String password = PasswordEncoder.encode("abc123");
		userServiceImpl.createUser(new User(1L,"Jefferson", "JeffMira", password, true));
		userServiceImpl.createUser(new User(2L, "Jack", "JackDaniels", password, false));
		userServiceImpl.createUser(new User(3L, "Joe", "Joe Molina", password, false));
		userServiceImpl.createUser(new User(4L, "Moe", "Moes pub", password, true));
	}
}
