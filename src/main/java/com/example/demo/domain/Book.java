package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
