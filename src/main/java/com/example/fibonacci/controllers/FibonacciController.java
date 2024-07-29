package com.example.fibonacci.controllers;

import com.example.fibonacci.models.Fibonacci;
import com.example.fibonacci.models.Time;
import com.example.fibonacci.services.FibonacciService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fibonacci")
@Tag(name = "Fibonacci", description = "Operations related to Fibonacci series")
public class FibonacciController {

    private final FibonacciService fibonacciService;

    @Autowired
    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @Operation(summary = "Calculate Fibonacci's Serie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fibonacci serie was successfully created",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Fibonacci.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Fibonacci not found",
                    content = @Content)
    })
    @PostMapping("/calculate")
    public ResponseEntity<Fibonacci> saveFibonacciSeries(@RequestBody Time timeRequest) {
        Fibonacci fibonacci = fibonacciService.saveFibonacciSeries(timeRequest.getTime());

        if (fibonacci != null) {
            return new ResponseEntity<>(fibonacci, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get a Fibonacci List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Fibonacci List",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Fibonacci.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Fibonacci not found",
                    content = @Content)
    })
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Fibonacci>> getAllFibonacciSeries() {
        List<Fibonacci> fibonacciSeries = fibonacciService.getAllFibonacciSeries();
        return new ResponseEntity<>(fibonacciSeries, HttpStatus.OK);
    }

}
