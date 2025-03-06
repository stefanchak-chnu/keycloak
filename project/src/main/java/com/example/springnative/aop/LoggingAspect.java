package com.example.springnative.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* org.springframework.data.repository.Repository+. *(..))")
    public void repositoryMethods() {
    }

    @SneakyThrows
    @Around("repositoryMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getInterfaces()[0].getSimpleName();

        long before = System.currentTimeMillis();

        Object object = joinPoint.proceed();

        long after = System.currentTimeMillis();
        long duration = after - before;

        log.info("Execution of {}.{}(..) method took {} ms", className, methodName, duration);

        return object;
    }
}
