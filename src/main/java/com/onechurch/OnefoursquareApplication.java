package com.onechurch;

import com.onechurch.process.domain.User;
import com.onechurch.process.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * RESTful API HATEOAS - Hypermedia AS the Engine of Application State:
 * 1) service should provide navegation data
 * 2) documentation
 * 3) Hypermedia driven out of box
 */
@SpringBootApplication
public class OnefoursquareApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(OnefoursquareApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		userService.createUser(new User(1L, "Jefferson", "abc"));
		userService.createUser(new User(2L, "Jack", "abc"));
		userService.createUser(new User(3L, "Joe", "abc"));
		userService.createUser(new User(4L, "Moe", "abc"));
	}
}
