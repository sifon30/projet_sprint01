package com.saif.montres;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.saif.montres.entities.Montre;
import com.saif.montres.service.MontreService;

@SpringBootApplication
public class MontresApplication implements CommandLineRunner{
		@Autowired
		MontreService montreService ;
		
		@Autowired
		private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(MontresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Montre.class);

		
	}

}
 