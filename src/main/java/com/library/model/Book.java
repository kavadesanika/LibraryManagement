package com.library.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String author;

    public Book() {}
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters/Setters
}
