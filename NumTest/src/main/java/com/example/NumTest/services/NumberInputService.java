package com.example.NumTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.NumTest.repositories.NumberInputRepository;
import com.example.NumTest.models.NumberInput;

@Service
public class NumberInputService {
    @Autowired
    private NumberInputRepository repository;

    public void saveNumber(int number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Number must be between 1 and 10");
        }
        NumberInput input = new NumberInput();
        input.setNumberValue(number);
        repository.save(input);
    }

    public Map<Integer, Long> getNumberCounts() {
        List<Object[]> results = repository.getNumberCounts();
        Map<Integer, Long> counts = new HashMap<>();
        for (Object[] result : results) {
            counts.put((Integer) result[0], (Long) result[1]);
        }
        return counts;
    }
}

