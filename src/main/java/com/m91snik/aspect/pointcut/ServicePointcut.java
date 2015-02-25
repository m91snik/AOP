/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.pointcut;

import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.Pointcut;

public class ServicePointcut {

//    @Pointcut("execution(@com.m91snik.annotation.SessionRequired * com.m91snik.business.service..*(..))")
    @Pointcut("execution(* com.m91snik.business.service..*(..))")
    public void businessMethodPointcut(){
    }

    @Pointcut("execution(@com.m91snik.annotation.SessionRequired * com.m91snik.business.service..*(..))")
    public void securedBusinessMethodPointcut(){
    }

}
