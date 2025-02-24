package com.example.demo.Controller;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    // Dependency Injection using Constructor
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Endpoint to return greeting message based on name parameters
    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        String message = greetingService.getGreetingMessage(firstName, lastName);
        greetingService.saveGreeting(message); // Save the greeting in the DB

        Map<String, String> response = new HashMap<>();
        response.put("message", message);

        return ResponseEntity.ok(response); // ✅ Returns 200 OK with JSON response
    }

    // Retrieve all greetings
    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        return ResponseEntity.ok(greetingService.getAllGreetings());
    }

    // Retrieve a greeting message by ID
    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        Greeting greeting = greetingService.getGreetingById(id);
        if (greeting != null) {
            return ResponseEntity.ok(greeting);
        } else {
            return ResponseEntity.notFound().build(); // ✅ Returns 404 if not found
        }
    }

    // Save a new greeting message
    @PostMapping
    public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting) {
        Greeting savedGreeting = greetingService.saveGreeting(greeting.getMessage());
        return ResponseEntity.ok(savedGreeting);
    }
}
