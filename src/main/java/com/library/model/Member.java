package com.library.model;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    public Member() {}
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters/Setters
}
