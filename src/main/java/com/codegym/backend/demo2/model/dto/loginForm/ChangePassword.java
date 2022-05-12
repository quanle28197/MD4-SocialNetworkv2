package com.codegym.backend.demo2.model.dto.loginForm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePassword {
    private String password;
    private String confirmPassword;
}
