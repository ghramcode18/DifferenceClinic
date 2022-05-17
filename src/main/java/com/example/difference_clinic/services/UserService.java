package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.example.difference_clinic.entities.Account;
import com.example.difference_clinic.entities.Role;
import com.example.difference_clinic.repositories.AccountRepo;
import com.example.difference_clinic.repositories.RoleRepo;
import com.example.difference_clinic.repositories.UserEntityRepo;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserService implements  UserDetailsService {
    
    private   RoleRepo roleRepo;
    
    private   PasswordEncoder passwordEncoder;
    
    private  final AccountRepo accountRepo;

    public UserService(AccountRepo accountRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.accountRepo = accountRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addRoleToUser(String username, String roleName) {
        // Logger("Adding role {} to ",roleName ,username);
        Account account = accountRepo.findByUserName(username);
        Role role = roleRepo.findByName(roleName);
        account.getRoles().add(role);
    }

    public Account getUser(String username) {
        // Logger("Fetching user {}",username);
        return accountRepo.findByUserName(username);
    }

    public List<Account> getUsers() {
        // Logger("Fetching All users {}");

        return accountRepo.findAll();
    }

    public Role saveRole(Role role) {
        // Logger("saving new role{} to the database ",role.getName());

        return roleRepo.save(role);
    }

    public Account saveUser(Account account) {
        // Logger("saving new user{} to the database ",user.getName());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepo.save(account);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUserName(username);
        if (account == null) {// log.error("user not found in the database");
            throw new UsernameNotFoundException("user not found in the database");

        } else {// log.error("user found in the database:{}",username);}
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            account.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new org.springframework.security.core.userdetails.User(account.getUserName(), account.getPassword(),
                    authorities);
        }
    }

}
