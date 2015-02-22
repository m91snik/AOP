/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class ServicePointcut {

    @Pointcut("execution(* com.m91snik.business..*(..))")
    public void businessMethodPointcut(){
    }
}
