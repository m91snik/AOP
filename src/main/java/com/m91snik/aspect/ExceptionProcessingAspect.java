/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect;

import com.m91snik.business.exception.ImportantException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//NOTE: for Spring AOP
@Component

@Aspect
public class ExceptionProcessingAspect {

    @AfterThrowing(pointcut = "execution(* com.m91snik.business.service..*(..))",
            throwing = "e")
    public void checkUserPermission(Throwable e) throws Throwable {
        if (!(e instanceof ImportantException)) {
            throw e;
        }
        System.out.println("ExceptionProcessingAspect begin");
        //TODO: send notification
        System.out.println("Sending exception notification..." + e.getMessage());

        System.out.println("ExceptionProcessingAspect end");
        throw e;
    }

}
