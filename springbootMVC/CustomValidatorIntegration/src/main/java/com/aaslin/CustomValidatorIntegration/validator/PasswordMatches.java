package com.aaslin.CustomValidatorIntegration.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

//because we validate multiple fields together, not a single field.
@Target(ElementType.TYPE) // Apply to class
@Retention(RetentionPolicy.RUNTIME) //so it works when the app is running
@Constraint(validatedBy = PasswordMatchesValidator.class) //tells which class contains the logic
@Documented // shows in Javadoc
public @interface PasswordMatches {
    String message() default "Password and Confirm Password must match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

