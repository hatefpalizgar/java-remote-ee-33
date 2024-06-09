package com.sda.p16_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Month;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {
    // Although value is written like a method, but it's not.
    // It's rather called an 'Element' of the annotation.
    // 'Element' defined this way can become arguments of the annotation.

    // There are certain limitations around 'Element's:
    // 1. return type of the 'Element' must be
    //   - simple types (e.g. int, float, double) and their object-oriented counterparts (e.g.
    // Integer, Double)
    //   - String class
    //   - Enum class
    //   - Other annotation classes
    //   - arrays of the types as mentioned above
    // 2. 'Element' cannot take any arguments (i.e. look like method declarations with no arguments)
    String[] value();

    String[] dates() default {};

    Month month() default Month.JANUARY;
}
