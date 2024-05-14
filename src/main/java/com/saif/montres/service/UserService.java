package com.saif.montres.service;

import com.saif.montres.entities.Role;
import com.saif.montres.entities.User;

public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}