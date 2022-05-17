package com.example.difference_clinic.services;


import com.example.difference_clinic.entities.Role;
import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.repositories.RoleRepo;
import com.example.difference_clinic.repositories.UserRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service()
public class UserService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;    

    
    

    public UserRepo getUserRepo() {
        return userRepo;
    }

    
    public void addRoleToUser(String username, String roleName) {
        UserEntity user = userRepo.findByUserName(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    
    public UserEntity getUser(String username) {
        return userRepo.findByUserName(username);
    }

    
    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }

    
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    
    public UserEntity saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found in the database");

        } else {
            System.out.print("user found in the db"+username);
        }
          Collection<SimpleGrantedAuthority> authorities = new ArrayList();
            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                    authorities);
        } 
    
}
