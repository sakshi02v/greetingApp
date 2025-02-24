package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage() {
        return "Hello";
    }

    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello, World!";
        }
    }

    public Greeting saveGreeting(String message) {
        return greetingRepository.save(new Greeting(message));
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

 // To search message by id
    public String getGreetingMessageById(Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if(greeting.isPresent()) {
            return greeting.get().getMessage();
        }
        else {
            return "There is no such message with entered id";
        }
    }
        
    // Method to update the message in the repository
    public String updateMessage(Long id, String newMessage) {
        List<Greeting> greetings = greetingRepository.findAll();
        for(Greeting greet:greetings) {
            if(Objects.equals(greet.getId(), id)) {
                greet.setMessage(newMessage);
                return greet.getMessage();
            }
        }
        return "No such id present in repository";
        
    }
}
