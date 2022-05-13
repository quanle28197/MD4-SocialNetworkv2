package com.codegym.backend.demo2.model.dto.loginForm;


import com.codegym.backend.demo2.validator.PasswordConfirm;
import com.codegym.backend.demo2.validator.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    @NotEmpty
    @UniqueUsername
    @Size(min = 5, max = 12)
    private String username;  
    private String password;
    private String confirmPassword;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String dateOfBirth;
    private String address;

    @PasswordConfirm
    private PasswordForm passwordForm;
}
