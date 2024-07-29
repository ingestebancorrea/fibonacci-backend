package com.example.fibonacci.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="series")
public class Fibonacci {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size", nullable = false)
    private int size;

    @Column(name = "seed1", nullable = false)
    private int seed1;

    @Column(name = "seed2", nullable = false)
    private int seed2;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    public Fibonacci() {
    }

    public Fibonacci(Long id, int size, int seed1, int seed2, String series, LocalDateTime creationDate) {
        this.id = id;
        this.size = size;
        this.seed1 = seed1;
        this.seed2 = seed2;
        this.series = series;
        this.creationDate = creationDate;
    }

    public Fibonacci(int size, int seed1, int seed2, String series, LocalDateTime creationDate) {
        this.size = size;
        this.seed1 = seed1;
        this.seed2 = seed2;
        this.series = series;
        this.creationDate = creationDate;
    }

    public Fibonacci(Long id, String series) {
        this.id = id;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSeed1() {
        return seed1;
    }

    public void setSeed1(int seed1) {
        this.seed1 = seed1;
    }

    public int getSeed2() {
        return seed2;
    }

    public void setSeed2(int seed2) {
        this.seed2 = seed2;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
