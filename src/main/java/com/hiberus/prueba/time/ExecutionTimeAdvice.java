package com.hiberus.prueba.time;


import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
@Slf4j
public class ExecutionTimeAdvice {
	
	Logger logger = LogManager.getLogger(ExecutionTimeAdvice.class);
	
	@Around("@annotation(com.hiberus.prueba.time.ExecutionTime)")
	public Object executionTime(ProceedingJoinPoint point) throws Throwable {
		long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        logger.info("Class Name: "+ point.getSignature().getDeclaringTypeName() +". Method Name: "+ point.getSignature().getName() + ". Time taken for Execution is : " + (endtime-startTime) +"ms");
        return object;
	}
}
