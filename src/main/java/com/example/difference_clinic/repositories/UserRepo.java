package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long>{
    UserEntity  findByUserName(String username);
    

}
