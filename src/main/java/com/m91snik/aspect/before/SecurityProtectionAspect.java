/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.before;

import com.m91snik.contract.SessionRequired;
import com.m91snik.business.session.SessionService;
import com.m91snik.business.session.dto.Group;
import com.m91snik.business.session.dto.Session;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Aspect
public class SecurityProtectionAspect {

    @Autowired
    private SessionService sessionService;

    //NOTE: it provides more flexibility than Spring @Secured contract because you can use any pointcut here
    @Before("com.m91snik.aspect.pointcut.ServicePointcut.securedBusinessMethodPointcut() && @annotation(sessionRequired)")
    public void checkUserPermission(SessionRequired sessionRequired) throws Throwable {
        Session currentSession = sessionService.getCurrentSession();

        if (currentSession == null) {
            throw new IllegalStateException("Session is null");
        }

        if (!checkPermissions(sessionRequired, currentSession)) {
            System.err.println("Security rules violated, group is " + currentSession.getGroup());
            throw new IllegalStateException(currentSession.getGroup() + " not allowed");
        }
    }

    private boolean checkPermissions(SessionRequired sessionRequired, Session currentSession) {
        Group currentGroup = currentSession.getGroup();
        return Arrays.stream(sessionRequired.group()).filter(group -> group == currentGroup).findFirst().isPresent();
    }

}
