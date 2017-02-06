package com.aspect;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;


@Aspect
public class LoggingAspect {
	 private Logger log = Logger.getLogger(getClass());

	
	@Around("execution(* com.controller.HelloWorldController.*(..))")
    public void logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable 
    {
        System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
        log.info(joinPoint.getSignature().getName() + " called... Using Logger............");
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": After Method Execution");
    }

	@Around("execution(* com.controller.HelloWorldController.addEmployee(..))") 
    public void logAroundGetEmployee(ProceedingJoinPoint joinPoint) throws Throwable 
    {
        System.out.println("****LoggingAspect.logAroundGetEmployee() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
        log.info(joinPoint.getSignature().getName() + " called... Using Logger............");
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        System.out.println("****LoggingAspect.logAroundGetEmployee() : " + joinPoint.getSignature().getName() + ": After Method Execution");
    }
 
    @Around("execution(* com.controller.HelloWorldController.updateEmployee(..))")
    public void logAroundCreateEmployee(ProceedingJoinPoint joinPoint) throws Throwable 
    {
        System.out.println("****LoggingAspect.logAroundCreateEmployee() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        System.out.println("****LoggingAspect.logAroundCreateEmployee() : " + joinPoint.getSignature().getName() + ": After Method Execution");
    }
}

