package com.codegym.backend.demo2.validator;

import com.codegym.backend.demo2.model.dto.loginForm.PasswordForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<PasswordConfirm, PasswordForm> {
    @Override
    public boolean isValid(PasswordForm passwordForm, ConstraintValidatorContext context) {
        return passwordForm.getPassword().equals(passwordForm.getConfirmPassword());
    }
}
