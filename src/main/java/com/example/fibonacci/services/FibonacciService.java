package com.example.fibonacci.services;

import com.example.fibonacci.models.Fibonacci;
import com.example.fibonacci.repository.FibonacciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class FibonacciService {

    @Autowired
    private FibonacciRepository fibonacciRepository;

    public Fibonacci saveFibonacciSeries(String time) {
        try {
            String[] timeParts = time.split(":");
            int seed1 = Integer.parseInt(timeParts[1]); // X - Seed1
            int seed2 = Integer.parseInt(timeParts[2]); // Y - Seed2

            // Validate seeds and size
            if (seed1 < 0 || seed2 < 0) {
                throw new IllegalArgumentException("Seeds must be non-negative.");
            }
            if (seed2 == 0) {
                throw new IllegalArgumentException("Size must be greater than zero.");
            }

            // Generate the Fibonacci series
            List<Integer> fibonacciSeries = generateFibonacciSeries(seed1, seed2);

            // Sort in descending order
            Collections.reverse(fibonacciSeries);

            // Create a new Fibonacci entity
            Fibonacci fibonacci = new Fibonacci();
            fibonacci.setSeed1(seed1);
            fibonacci.setSeed2(seed2);
            fibonacci.setSize(fibonacciSeries.size());
            fibonacci.setSeries(fibonacciSeries.toString());
            fibonacci.setCreationDate(LocalDateTime.now());

            return fibonacciRepository.save(fibonacci);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Integer> generateFibonacciSeries(int seed1, int seed2) {
        List<Integer> series = new ArrayList<>();
        if (seed2 <= 0) return series;

        int a = seed1;
        int b = seed2;
        series.add(a);
        series.add(b);

        while (series.size() < seed2 + 2) {
            int next = a + b;
            series.add(next);
            a = b;
            b = next;
        }

        return series;
    }

    public List<Fibonacci> getAllFibonacciSeries() {
        return fibonacciRepository.findAllFibonacciSeries();
    }
}
