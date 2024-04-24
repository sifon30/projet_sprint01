package com.saif.montres;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saif.montres.entities.Montre;
import com.saif.montres.service.MontreService;

@SpringBootApplication
public class MontresApplication implements CommandLineRunner{
		@Autowired
		MontreService montreService ;
	public static void main(String[] args) {
		SpringApplication.run(MontresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		montreService.saveMontre(new Montre("Seiko",100.00,new Date()));
		montreService.saveMontre(new Montre("Boss",400.00,new Date()));
		montreService.saveMontre(new Montre("Swatch",600.00,new Date()));

		
	}

}
