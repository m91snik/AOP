/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.flow;

import com.google.gson.Gson;
import com.m91snik.business.session.dto.Session;
import com.m91snik.contract.HasRefId;
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

    @Pointcut("execution(* com.m91snik.facade.PaymentServiceFacade.*(com.m91snik.contract.HasRefId+,..)) && args(hasRefId,..)")
    public void paymentServiceFacadeUsage(HasRefId hasRefId) {
    }

    @Pointcut("execution(public * com.m91snik.business.service..*(..))")
    public void paymentServiceFacadeCalls() {
    }

    @Around("cflow(paymentServiceFacadeUsage(hasRefId)) && paymentServiceFacadeCalls()")
    public Object logMethodExecution(HasRefId hasRefId, ProceedingJoinPoint joinPoint) throws Throwable {
        String refId = hasRefId.getRefId();

        String methodContext = "Session = " + refId + ". Method " + joinPoint.toShortString();
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
