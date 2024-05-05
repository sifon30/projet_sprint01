package com.saif.montres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saif.montres.entities.Genre;

public interface GenreRepository  extends JpaRepository<Genre, Long> {

}
