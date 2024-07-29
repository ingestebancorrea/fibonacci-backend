package com.example.fibonacci.controllers;

import com.example.fibonacci.models.Fibonacci;
import com.example.fibonacci.models.Time;
import com.example.fibonacci.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fibonacci")
public class FibonacciController {

    private final FibonacciService fibonacciService;

    @Autowired
    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Fibonacci> saveFibonacciSeries(@RequestBody Time timeRequest) {
        Fibonacci fibonacci = fibonacciService.saveFibonacciSeries(timeRequest.getTime());

        if (fibonacci != null) {
            return new ResponseEntity<>(fibonacci, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Fibonacci>> getAllFibonacciSeries() {
        List<Fibonacci> fibonacciSeries = fibonacciService.getAllFibonacciSeries();
        return new ResponseEntity<>(fibonacciSeries, HttpStatus.OK);
    }

}
