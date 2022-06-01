package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository <Role,Integer> {
    Role  findByName(String name);

}
