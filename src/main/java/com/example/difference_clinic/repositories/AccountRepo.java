package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.Account;
import com.example.difference_clinic.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{
    Account  findByUserName(String username);
    

}