package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private Logger logger =  LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.example.spring_boot_rest.job.JobController.*(..))")
    public void log(JoinPoint jp) {
        logger.info("Method called" + jp.getSignature().getName());
    }
    
    @After("execution(* com.example.spring_boot_rest.job.JobController.*(..))")
    public void logAfter(JoinPoint jp) {
        logger.info("logged after" + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.spring_boot_rest.job.JobController.*(..))")
    public void logAfterReturning(JoinPoint jp) {
        logger.info("loging after return"+ jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.spring_boot_rest.job.JobController.*(..))")
    public void LogAfterAnException(JoinPoint jb) {
        logger.info("logged due to exception" + jb.getArgs());
    }
}
