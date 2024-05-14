package com.saif.montres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saif.montres.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}