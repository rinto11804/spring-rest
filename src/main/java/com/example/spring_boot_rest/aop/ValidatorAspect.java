package com.example.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidatorAspect {
    
    @Around("execution(* com.example.spring_boot_rest.job.JobController.getJobById(..)) && args(jobId)")
    public Object validator(ProceedingJoinPoint pj,int jobId)  throws Throwable{
        System.out.println("JobId:" + jobId);
        if (jobId < 0) {
            jobId = jobId * -1;
        }
        Object obj =  pj.proceed(new Object[]{jobId});
        System.out.println(obj);
        return obj;
    }
}
