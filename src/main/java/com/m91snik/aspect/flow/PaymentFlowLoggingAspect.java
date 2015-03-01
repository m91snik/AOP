/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.flow;

import com.google.gson.Gson;
import com.m91snik.business.session.dto.Session;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect//("percflow(execution(public void com.m91snik.business.facade.PaymentServiceFacade.creditPayment(..)))")
public class PaymentFlowLoggingAspect {

    private static final Gson GSON = new Gson();

    public PaymentFlowLoggingAspect() {
        System.out.println("FlowLoggingAspect init");
    }

    @Pointcut("execution(* com.m91snik.facade.PaymentServiceFacade.*(com.m91snik.business.session.dto.Session,..)) && args(session,..)")
    public void paymentServiceFacadeUsage(Session session) {
    }

    @Pointcut("execution(public * com.m91snik.business.service..*(..))")
    public void paymentServiceFacadeCalls() {
    }

    @Around("cflow(paymentServiceFacadeUsage(session)) && paymentServiceFacadeCalls()")
    public Object logMethodExecution(Session session, ProceedingJoinPoint joinPoint) throws Throwable {
        String internalReferenceId = session.getInternalReferenceId();

        String methodContext = "Session = " + internalReferenceId + ". Method " + joinPoint.toShortString();
        System.out.println(methodContext + " with args " + "" + GSON.toJson(joinPoint.getArgs()));
        Object result;
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
            System.out.println(methodContext + " returned " + GSON.toJson(result));
        } catch (Throwable t) {
            System.out.println(methodContext + " throw " + t.getMessage());
            throw t;
        }
        return result;
    }
}
