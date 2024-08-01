package com.example.NumTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.example.NumTest.services.NumberInputService;

@RestController
@RequestMapping("/api/numbers")
@CrossOrigin(origins = "http://localhost:3000")
public class NumberInputController {
    @Autowired
    private NumberInputService service;

    @PostMapping
    public ResponseEntity<?> saveNumber(@RequestBody Map<String, Integer> payload) {
        try {
            int number = payload.get("number");
            service.saveNumber(number);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/counts")
    public ResponseEntity<Map<Integer, Long>> getNumberCounts() {
        return ResponseEntity.ok(service.getNumberCounts());
    }
}
