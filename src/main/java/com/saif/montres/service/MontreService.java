package com.saif.montres.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.saif.montres.entities.Genre;
import com.saif.montres.entities.Montre;

public interface MontreService {
	
	Montre saveMontre(Montre m);
	Montre updateMontre(Montre m);
	void deleteMontre(Montre m);
	 void deleteMontreById(Long id);
	Montre getMontre(Long id);
	List<Montre> getAllMontres();
	Page<Montre> getAllMontresParPage(int page, int size);
	
	List<Montre> findByNomMontre(String nom);
	List<Montre> findByNomMontreContains(String nom);
	List<Montre> findByNomPrix (String nom, Double prix);
	List<Montre> findByGenre (Genre genre);
	List<Montre> findByGenreIdGen(Long id);
	List<Montre> findByOrderByNomMontreAsc();
	List<Montre> trierMontresNomsPrix();




}
