package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.service.GreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;


    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET request with optional firstName and lastName query parameters
    @GetMapping
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getParametrizedGreeting(firstName, lastName);
    }

    // POST request remains unchanged
    @PostMapping
    public String postGreeting() {
        return "Greeting created successfully!";
    }
}
