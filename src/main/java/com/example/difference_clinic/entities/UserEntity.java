package com.example.difference_clinic.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data 
@Setter 
@Getter
@RequiredArgsConstructor
@Table(name = "UserEntity")
public class UserEntity {
  
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobile;
    private String gender;
    private String job;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Long score;
    private String socialStatus;
    private boolean isActive;
    private String codeNum;
    

}
