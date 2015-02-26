/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//NOTE: for Spring AOP
@Component
//NOTE: set precedence for Spring AOP
@Order(1)

@Aspect
public class LoggingAspect {

    private static final Gson GSON = new Gson();

//    @Around("com.m91snik.aspect.pointcut.TrickyServicePointcut.businessMethodCallPointcut()")
//    @Around("com.m91snik.aspect.pointcut.TrickyServicePointcut.businessMethodPointcutWithin()")
    @Around("com.m91snik.aspect.pointcut.ServicePointcut.businessMethodPointcut()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LoggingAspect begin");

        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + " - arguments {" + GSON.toJson(args) + "}");
        Object result = joinPoint.proceed(args);
        System.out.println(joinPoint.getSignature().getName() + " - result {" + GSON.toJson(result) + "}");

        System.out.println("LoggingAspect end");
        return result;
    }

}
