package com.example.fibonacci.repository;

import com.example.fibonacci.models.Fibonacci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FibonacciRepository extends JpaRepository<Fibonacci, Long> {

    @Query("SELECT f FROM Fibonacci f")
    List<Fibonacci> findAllFibonacciSeries();

}
