package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.Role;
import com.example.difference_clinic.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long>{

    Role  findByName(String name);
}

