package com.m91snik.contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use this contract on methods which should requires session
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface UnsafeOperation {

}
