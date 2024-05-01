package com.saif.montres;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.saif.montres.repos.MontreRepository;
import com.saif.montres.service.MontreService;
import com.saif.montres.entities.Genre;
import com.saif.montres.entities.Montre;

@SpringBootTest
class MontresApplicationTests {

	@Autowired
	private MontreRepository montreRepository;
	@Autowired
	private  MontreService montreService;
	@Test
	public void testCreateMontre() {
	Montre mon = new Montre("rolex",3000.500,new Date());
	montreRepository.save(mon);
	}
	
	@Test
	public void testFindMontre()
	{
	Montre m = montreRepository.findById(1L).get(); 
	System.out.println(m);
	}
	
	
	@Test
	public void testUpdateMontre()
	{
	Montre m = montreRepository.findById(2L).get(); 
	m.setPrixMontre(300.0);
	montreRepository.save(m);
	}
	
	@Test
	public void testDeleteMontre()
	{
	montreRepository.deleteById(2L);;
	}
	
	@Test
	public void testListerTousMontres()
	{
	List<Montre> mons = montreRepository.findAll();
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}
	
	
	
	@Test
	public void testFindByNomMontreContains()
	{
	Page<Montre> mons = montreService.getAllMontresParPage(0,2);
	System.out.println(mons.getSize());
	System.out.println(mons.getTotalElements());
	System.out.println(mons.getTotalPages());
	mons.getContent().forEach(m -> {System.out.println(m.toString());
	 });
	/*ou bien
	for (Montre m : mons)
	{
	System.out.println(m);
	} */
	}
	
	@Test
	public void testFindMontreByNom()
	{
	List<Montre> mons = montreRepository.findByNomMontre("rolex");
	for (Montre m : mons)
	{
	System.out.println(m);
	}	}
	
	
	
	@Test
	public void testFindMontreByNomContains()
	{
	List<Montre> mons = montreRepository.findByNomMontreContains("C");
	for (Montre m : mons)
	{
	System.out.println(m);
	}	}
	
	
	@Test
	public void testfindByNomPrix()
	{
	List<Montre> mons = montreRepository.findByNomPrix("Casio", 200.0);
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}
	
	
	@Test
	public void testfindByGenre()
	{
	Genre gen = new Genre();
	gen.setIdGen(1L);
	List<Montre> mons = montreRepository.findByGenre(gen);
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}
	
	@Test
	public void findByGenreIdGen()
	{
	List<Montre> mons = montreRepository.findByGenreIdGen(1L);
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	 }
	
	
	@Test
	public void findByOrderByNomMontreAsc()
	{
	List<Montre> mons = 
			montreRepository.findByOrderByNomMontreAsc();
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}
	
	@Test
	public void testTrierMontresNomsPrix()
	{
	List<Montre> mons = montreRepository.trierMontresNomsPrix();
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}

	
}
