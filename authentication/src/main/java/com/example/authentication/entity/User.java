package com.example.authentication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String passwordHash;

    private String name;

    private String surname;

    @Transient
    private List<Long> surveyIds;

    public User() {
    }

    public User(String email, String passwordHash, String name, String surname) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = name;
        this.surname = surname;
    }

}
