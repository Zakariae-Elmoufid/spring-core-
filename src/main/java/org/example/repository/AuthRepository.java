package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
