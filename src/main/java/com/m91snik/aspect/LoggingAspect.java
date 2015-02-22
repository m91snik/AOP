/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Gson GSON = new Gson();

    @Around("com.m91snik.aspect.pointcut.ServicePointcut.businessMethodPointcut()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + " - arguments {" + GSON.toJson(args) + "}");
        Object result = joinPoint.proceed(args);
        System.out.println(joinPoint.getSignature().getName() + " - result {" + GSON.toJson(result) + "}");
        return result;
    }

}
