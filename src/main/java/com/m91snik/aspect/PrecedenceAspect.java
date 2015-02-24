/**
 * Created by nikolay.garbuzov on 23.02.15.
 */
package com.m91snik.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;
import org.springframework.stereotype.Component;

@Aspect
@DeclarePrecedence("com.m91snik.aspect.SecurityProtectionAspect,com.m91snik.aspect.LoggingAspect")
public class PrecedenceAspect {
}
