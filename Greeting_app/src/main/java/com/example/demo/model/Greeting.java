package com.example.demo.model;

import org.springframework.aot.generate.GenerationContext;

import jakarta.annotation.Generated;

@Entity
public class Greeting {

    @Id
    @Generated(strategy = GenerationContext.IDENTITY)
    private Long id;
    private String message;

    // Constructors
    public Greeting() {}

    public Greeting(String message) {
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}