package com.example.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfromanceAspect {

    private Logger logger = LoggerFactory.getLogger(PerfromanceAspect.class);

    @Around("execution(* com.example.spring_boot_rest.job.JobController.*(..))")
    public Object performance(ProceedingJoinPoint pj) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj =  pj.proceed();
        long end = System.currentTimeMillis();

        logger.info("Execution time " + (end - start) + "ms");
        return obj;
    }
}
