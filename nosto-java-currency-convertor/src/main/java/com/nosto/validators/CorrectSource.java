package com.nosto.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.RetentionPolicy;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CorrectSourceValidator.class)
public @interface CorrectSource {
    String message() default "Wrong source input";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}