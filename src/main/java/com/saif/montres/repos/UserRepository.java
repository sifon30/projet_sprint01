package com.saif.montres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saif.montres.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}