package com.example.difference_clinic.services;

import java.util.List;

import com.example.difference_clinic.entities.Role;
import com.example.difference_clinic.entities.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
User saveUser (User user); 
 Role saveRole(Role role);
 void addRoleToUser(String username,String roleName);
 User getUser(String username);
 List <User> getUsers();
 
}
