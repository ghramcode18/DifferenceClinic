package com.example.difference_clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class DifferenceClinicApplication {

 public static void main(String[] args) {
  SpringApplication.run(DifferenceClinicApplication.class, args);
 }


 @Bean
 PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();

 }
}
