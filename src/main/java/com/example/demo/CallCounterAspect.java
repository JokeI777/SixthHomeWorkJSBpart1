package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class CallCounterAspect {

    @Value("${maxNumber}")
    int maxCallNumber;
    @Value("0")
    static int counterCallFirstApi;
    @Value("0")
    static int counterCallSecondApi;
    static final Logger logger = Logger.getLogger("API");

    @Around("@annotation(com.example.demo.CallCounter)")
    public Object counterLogic(ProceedingJoinPoint point) throws Throwable{

        MethodSignature signature = (MethodSignature) point.getSignature();
        if(signature.getMethod().getName() == "firstApi" && counterCallFirstApi < maxCallNumber){
            counterCallFirstApi++;
            logger.info("First called: " + counterCallFirstApi);
            return point.proceed();
        }
        else if(signature.getMethod().getName() == "secondApi" && counterCallSecondApi < maxCallNumber){
            counterCallSecondApi++;
            logger.info("Second called: " + counterCallSecondApi);
            return point.proceed();
        }
        else {
            logger.info(signature.getMethod().getName() + ": max call number reached");
            return null;
        }

    }
}
