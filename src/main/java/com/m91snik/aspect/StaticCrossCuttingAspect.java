package com.m91snik.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.DeclareWarning;

/**
 * Created by nikolay.garbuzov on 25.02.15.
 */
@Aspect
public class StaticCrossCuttingAspect {

    //TODO: compare with static analyzer
    @DeclareWarning("call(* com.m91snik.business.service.BankService.*(..))")
    private static final String UNSAFE_USAGE_ERROR = "Usage of unsafe method!";

    @DeclareError("get(* System.out) && within(com.m91snik.business.service..*)")
    private static final String DEFAULT_LOGGING_USAGE = "Use log4j instead of System.out!!";
}
