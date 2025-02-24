package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public void saveGreeting(String message) {
        greetingRepository.save(new Greeting(message));
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public String getGreetingMessage() {
        return "Hello from GreetingService!";
    }
}

