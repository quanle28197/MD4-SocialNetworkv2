package com.codegym.backend.demo2.validator;

import com.codegym.backend.demo2.model.entity.AppUser;
import com.codegym.backend.demo2.repository.IUserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private IUserRepository userRepository;

    public UniqueUsernameValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        AppUser appUser = userRepository.findByUsername(username);
        if (appUser != null) {
            return false;
        }
        return true;
    }
}
