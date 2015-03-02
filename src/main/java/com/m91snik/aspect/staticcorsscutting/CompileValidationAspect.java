/**
 * Created by nikolay.garbuzov on 25.02.15.
 */
package com.m91snik.aspect.staticcorsscutting;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareWarning;

/**
 * Provides compile check rules
 */
@Aspect
public class CompileValidationAspect {

    @DeclareWarning("call(* com.m91snik.business.service.BankService.*(..))")
    private static final String UNSAFE_USAGE_ERROR = "Usage of unsafe method!";

    //NOTE: it's possible to use DeclareError also to forbid compilation in case of rule violation
    @DeclareWarning("get(* System.out) && within(com.m91snik.business.service..*)")
    private static final String DEFAULT_LOGGING_USAGE = "Use log4j instead of System.out!!";
}
