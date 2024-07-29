package com.example.fibonacci.models;

public class Time {
    private String time; // Expecting format HH:MM:SS

    public Time() {}

    public Time(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}