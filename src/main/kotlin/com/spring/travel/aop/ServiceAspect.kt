package com.spring.travel.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class ServiceAspect {

    private val logger = LoggerFactory.getLogger(ServiceAspect::class.java)

    @Around("execution(* com.spring.travel.service.*.*(..))")
    fun aroundAspectTest(proceedingJoinPoint: ProceedingJoinPoint): Any {
        logger.info("[{}] This service used detected", proceedingJoinPoint.signature.name)
        return proceedingJoinPoint.proceed()
    }

}