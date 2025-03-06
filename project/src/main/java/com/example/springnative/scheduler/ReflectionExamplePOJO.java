package com.example.springnative.scheduler;

import java.time.LocalDateTime;

public class ReflectionExamplePOJO {

    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "ReflectionExamplePOJO{%s}".formatted(timestamp);
    }
}
