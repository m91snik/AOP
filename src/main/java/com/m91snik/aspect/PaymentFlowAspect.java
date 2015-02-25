/**
 * Created by nikolay.garbuzov on 25.02.15.
 */
package com.m91snik.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PaymentFlowAspect {

    @Pointcut("cflow(execution(* com.m91snik.business.service.PaymentService.doCredit(..))) && within(com.m91snik.business.service..*)")
    public void flow() {
    }

    @Before("flow()")
    public void paymentFlow(JoinPoint joinPoint) {
        System.out.println("Payment flow tracking " + joinPoint.toLongString());
    }
}
