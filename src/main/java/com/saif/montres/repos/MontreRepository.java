package com.saif.montres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saif.montres.entities.Montre;

public interface MontreRepository extends JpaRepository<Montre, Long> {

}
