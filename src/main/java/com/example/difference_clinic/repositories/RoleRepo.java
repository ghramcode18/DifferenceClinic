package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.ERole;
import com.example.difference_clinic.entities.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository <Role,Integer> {

    Optional<Role> findByName(ERole name);

    Role findByName(String roleName);

}
