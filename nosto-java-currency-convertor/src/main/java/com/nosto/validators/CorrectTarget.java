package com.nosto.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.RetentionPolicy;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CorrectTargetValidator.class)
public @interface CorrectTarget {
    String message() default "Wrong target input";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}