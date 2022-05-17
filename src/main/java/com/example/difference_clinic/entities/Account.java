package com.example.difference_clinic.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity @Data 
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;
   private String userName;
   private String password;
//    private String num;

   @ManyToMany(fetch = FetchType.EAGER)
   private Collection <Role>roles= new ArrayList<>();

}