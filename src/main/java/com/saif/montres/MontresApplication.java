package com.saif.montres;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.saif.montres.entities.Montre;
import com.saif.montres.entities.Role;
import com.saif.montres.entities.User;
import com.saif.montres.service.MontreService;
import com.saif.montres.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MontresApplication implements CommandLineRunner{
		@Autowired
		MontreService montreService ;
		
		@Autowired
		PasswordEncoder passwordEncoder;
		
		@Autowired
		UserService userService ;

		
		@Autowired
		private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(MontresApplication.class, args);
	}
	
	
	/*
	@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"nadhem","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("nadhem", "USER");
	userService.addRoleToUser("nadhem", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}
*/
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Montre.class);
		
		
		//System.out.println("Password Encoded BCRYPT :******************** ");
		// System.out.println(passwordEncoder.encode("123"));

		
	}

}
 