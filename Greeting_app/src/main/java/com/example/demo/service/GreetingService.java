package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;


@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        return greetingRepository.save(new Greeting(message));


    }
}