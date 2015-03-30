/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.after;

import com.google.gson.Gson;
import com.m91snik.business.exception.ImportantException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * An example of exception processing aspect which applied after exception throwing and can be used to send notification
 */
@Aspect
public class ExceptionProcessingAspect {

    @AfterThrowing(pointcut = "execution(* com.m91snik.business.service..*(..))", throwing = "e")
    public void processImportantException(JoinPoint joinPoint, Throwable e) throws Throwable {
        if (!(e instanceof ImportantException)) {
            throw e;
        }
        System.out.println("Exception occurred in " + joinPoint.getSignature() +
                                   " with args " + new Gson().toJson(joinPoint.getArgs()));
        //NOTE: sending notification
        System.out.println("Sending exception notification..." + e.getMessage());
        throw e;
    }

}
