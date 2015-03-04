/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Collection of pointcuts
 */
public class ServicePointcut {

    @Pointcut("execution(* com.m91snik.business.service..*(..))")
    public void businessMethodPointcut(){
    }

    @Pointcut("execution(@com.m91snik.contract.SessionRequired * com.m91snik.business.service..*(..))")
    public void securedBusinessMethodPointcut(){
    }

    @Pointcut("execution(* com.m91snik.business..*(..)) && " +
            "(within(com.m91snik.business.service..*) || " +
            "within(com.m91snik.business.session.impl..*))")
    public void businessMethodPointcutWithin(){
    }

    @Pointcut("call(* com.m91snik.business..*(..)) && " +
            "(within(com.m91snik.business.service..*) || " +
            "within(com.m91snik.business.session.impl..*))")
    public void businessMethodCallPointcut(){
    }

}
