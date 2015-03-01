/**
 * Created by nikolay.garbuzov on 23.02.15.
 */
package com.m91snik.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;

@Aspect
@DeclarePrecedence("com.m91snik.aspect.before.SecurityProtectionAspect,com.m91snik.aspect.around.LoggingAspect")
public class PrecedenceAspect {
}
