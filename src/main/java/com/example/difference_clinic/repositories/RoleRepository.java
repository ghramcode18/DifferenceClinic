package com.example.difference_clinic.repositories;

import java.util.Optional;

import com.example.difference_clinic.entities.ERole;
import com.example.difference_clinic.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
