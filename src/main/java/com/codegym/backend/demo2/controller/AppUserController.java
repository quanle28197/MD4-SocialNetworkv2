package com.codegym.backend.demo2.controller;


import com.codegym.backend.demo2.model.dto.loginForm.ChangePassword;
import com.codegym.backend.demo2.model.dto.loginForm.JwtResponse;
import com.codegym.backend.demo2.model.dto.loginForm.SignUpForm;
import com.codegym.backend.demo2.model.entity.AppUser;
import com.codegym.backend.demo2.model.entity.UserInfo;
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

import java.util.Optional;

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
    public ResponseEntity<AppUser> register(@RequestBody SignUpForm user) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AppUser newUser = new AppUser(user.getUsername(), user.getPassword());
        appUserService.save(newUser);
        String avatar = "avatar.jpg";
        String background = "background.jpg";
         UserInfo userInfo = new UserInfo(user.getEmail(),user.getFullName(),user.getPhoneNumber(),
                user.getDateOfBirth(),user.getAddress(),avatar,background, newUser);
        userInfoService.save(userInfo);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/findUserId/{email}/{phone}")
    public ResponseEntity<AppUser> findUserId(@PathVariable String email, @PathVariable String phone) {
        Long userId = this.userInfoService.findUserId(email,phone);
        Optional<AppUser> appUser = this.appUserService.findById(userId);
        if (!appUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appUser.get(), HttpStatus.OK);
    }

    @PostMapping("/changePassword/{id}")
    public ResponseEntity<AppUser> changePassword(@PathVariable Long id, @RequestBody ChangePassword changePassword) {
        Optional<AppUser> appUser = this.appUserService.findById(id);
        String newPassword;
        if (!appUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (changePassword.getPassword().equals(changePassword.getConfirmPassword())) {
            newPassword = changePassword.getPassword();
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        appUser.get().setPassword(newPassword);
        return new ResponseEntity<>(appUser.get(), HttpStatus.OK);
    }


}

