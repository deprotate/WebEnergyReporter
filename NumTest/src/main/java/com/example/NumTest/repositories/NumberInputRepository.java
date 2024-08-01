package com.example.NumTest.repositories;

import com.example.NumTest.models.NumberInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NumberInputRepository extends JpaRepository<NumberInput, Long> {
    @Query("SELECT ni.numberValue, COUNT(ni) FROM NumberInput ni GROUP BY ni.numberValue")
    List<Object[]> getNumberCounts();
}