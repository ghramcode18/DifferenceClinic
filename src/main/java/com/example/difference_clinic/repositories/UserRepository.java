package com.example.difference_clinic.repositories;

import java.util.Optional;

import com.example.difference_clinic.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findByPassword(String password);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
