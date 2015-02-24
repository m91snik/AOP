/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class TrickyServicePointcut {

    @Pointcut("execution(* com.m91snik.business..*(..)) && " +
            "(within(com.m91snik.business.service..*) ||" +
            "within(com.m91snik.business.session.impl..*) || " +
            "within(com.m91snik.business.session.dto.Session))")
    public void businessMethodPointcutWithin(){
    }

    @Pointcut("call(* com.m91snik.business..*(..)) && " +
            "(within(com.m91snik.business.service..*) ||" +
            "within(com.m91snik.business.session.impl..*))")
    public void businessMethodCallPointcut(){
    }
}
