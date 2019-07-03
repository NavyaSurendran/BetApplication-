package com.spring.bet.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = BetTypeValidator.class)
@Documented
public @interface BetTypeConstraint {

	String message() default "Bet Type is not allowed. It Should be any of [WIN, PLACE, TRIFECTA, DOUBLE, QUADDIE]";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
