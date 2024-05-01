package com.saif.montres.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.saif.montres.entities.Genre;
import com.saif.montres.entities.Montre;
@RepositoryRestResource(path ="rest")

public interface MontreRepository extends JpaRepository<Montre, Long> {
	
	 List<Montre> findByNomMontre(String nom);
	 List<Montre> findByNomMontreContains(String nom);
	 
	/* @Query("select m from Montre m where m.nomMontre like %?1 and m.prixMontre > ?2")
	 List<Montre> findByNomPrix (String nom, Double prix);*/
	 
	 @Query("select m from Montre m where m.nomMontre like %:nom and m.prixMontre > :prix")
	 List<Montre> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	 @Query("select m from Montre m where m.genre = ?1")
	 List<Montre> findByGenre(Genre genre);
	 List<Montre> findByGenreIdGen(Long id);
	 List<Montre> findByOrderByNomMontreAsc();
	 @Query("select m from Montre m order by m.nomMontre ASC, m.prixMontre DESC")
	 List<Montre> trierMontresNomsPrix ();
	 
	 
	 
}
