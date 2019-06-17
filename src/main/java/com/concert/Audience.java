package com.concert;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* com.concert.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silence cell phones");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats.");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demand a refund.");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            System.out.println("Silence cell phones");
            System.out.println("Taking seats.");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP CLAP");
        }catch(Throwable s){
            System.out.println("Demand a refund.");
        }
    }
}
