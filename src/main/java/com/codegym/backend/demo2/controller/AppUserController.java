package com.codegym.backend.demo2.controller;


import com.codegym.backend.demo2.model.dto.loginForm.JwtResponse;
import com.codegym.backend.demo2.model.dto.loginForm.SignUpForm;
import com.codegym.backend.demo2.model.entity.AppUser;
import com.codegym.backend.demo2.service.JwtService;
import com.codegym.backend.demo2.service.user.IAppUserService;
import com.codegym.backend.demo2.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
public class AppUserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    // Hiển thị danh sách thông tin user

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser appUser) {
        //Kiểm tra username và pass
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
        //Lưu user đang đăng nhập vào trong context của security
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = appUserService.findByUsername(appUser.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@Valid @RequestBody SignUpForm appUser) {
        if (!appUser.getPasswordForm().getPassword().equals(appUser.getPasswordForm().getConfirmPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AppUser appUser1 = new AppUser(appUser.getUsername(), appUser.getPasswordForm().getPassword());
        return new ResponseEntity<>(appUserService.save(appUser1), HttpStatus.CREATED);
    }


}

