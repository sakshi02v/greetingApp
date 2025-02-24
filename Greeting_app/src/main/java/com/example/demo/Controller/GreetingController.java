package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // POST request to save a greeting

    @PostMapping
    public Greeting createGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
    }
}