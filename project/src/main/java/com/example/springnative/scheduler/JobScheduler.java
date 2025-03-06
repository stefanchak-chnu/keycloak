package com.example.springnative.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;

@Slf4j
@Component
public class JobScheduler {

    @Scheduled(fixedRate = 10000, initialDelay = 5000)
    public void executeTask() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        ReflectionExamplePOJO reflectionExamplePOJO = ReflectionExamplePOJO.class
                .getDeclaredConstructor()
                .newInstance();

        Field idField = reflectionExamplePOJO
                .getClass()
                .getDeclaredField("timestamp");

        idField.setAccessible(true);
        idField.set(reflectionExamplePOJO, LocalDateTime.now());

        log.info("Using reflection for class: {}", reflectionExamplePOJO);
    }
}
