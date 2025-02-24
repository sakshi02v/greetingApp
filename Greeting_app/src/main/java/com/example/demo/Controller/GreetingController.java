package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // GET request to return a greeting message
    @GetMapping
    public String getGreeting() {
        return "Hello, World!";
    }

    // POST request to return a custom greeting message
    @PostMapping
    public String postGreeting() {
        return "Greeting created successfully!";
    }
}