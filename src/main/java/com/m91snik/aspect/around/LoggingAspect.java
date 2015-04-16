/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.around;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    private static final Gson GSON = new Gson();

//  @Around("com.m91snik.aspect.pointcut.ServicePointcut.businessMethodCallPointcut()")
//  @Around("com.m91snik.aspect.pointcut.ServicePointcut.businessMethodPointcutWithin()")
    @Around("execution(* com.m91snik.business.service..*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        log(methodName + " - arguments {" + GSON.toJson(args) + "}");

        Object result;
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable t) {
            log(methodName + " - failed with " + t.getMessage());
            throw t;
        }

        log(methodName + " - result {" + GSON.toJson(result) + "}");

        return result;
    }

    private void log(String message) {
        System.out.println(message);
    }

}
