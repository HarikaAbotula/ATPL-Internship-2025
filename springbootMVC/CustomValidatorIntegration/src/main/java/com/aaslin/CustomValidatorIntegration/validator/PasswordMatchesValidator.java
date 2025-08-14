package com.aaslin.CustomValidatorIntegration.validator;

import com.aaslin.CustomValidatorIntegration.dto.UserRegistration;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRegistration> {

    @Override
    public boolean isValid(UserRegistration user, ConstraintValidatorContext context) {
       
        if (user.getPassword() == null || user.getConfirmPassword() == null) {
            return false; // Let @NotBlank handle this
        }
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
