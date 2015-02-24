/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect;

import com.m91snik.annotation.SessionRequired;
import com.m91snik.business.session.SessionService;
import com.m91snik.business.session.dto.Group;
import com.m91snik.business.session.dto.Session;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//NOTE: for Spring AOP
@Component

//NOTE: set precedence for Spring AOP
@Order(2)

@Aspect

public class SecurityProtectionAspect {

    @Autowired
    private SessionService sessionService;

    @Around("com.m91snik.aspect.pointcut.ServicePointcut.securedBusinessMethodPointcut() && @annotation(sessionRequired)")
    public Object checkUserPermission(ProceedingJoinPoint joinPoint, SessionRequired sessionRequired) throws Throwable {
        System.out.println("SecurityProtectionAspect begin");

        Session currentSession = sessionService.getCurrentSession();

        if (currentSession == null) {
            throw new IllegalStateException("Session is null");
        }

        if (!checkPermissions(sessionRequired, currentSession)) {
            System.out.println("SecurityProtectionAspect end");
            throw new IllegalStateException(currentSession.getGroup() + " not allowed");
        }

        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            System.out.println("SecurityProtectionAspect end");
        }
    }

    private boolean checkPermissions(SessionRequired sessionRequired, Session currentSession) {
        for (Group group : sessionRequired.group()) {
            if (group == currentSession.getGroup()) {
                return true;
            }
        }
        return false;
    }

}
