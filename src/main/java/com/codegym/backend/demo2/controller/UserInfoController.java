package com.codegym.backend.demo2.controller;


import com.codegym.backend.demo2.model.dto.AvatarForm;
import com.codegym.backend.demo2.model.dto.BackgroundForm;
import com.codegym.backend.demo2.model.entity.UserInfo;
import com.codegym.backend.demo2.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/userInfo")
public class UserInfoController {

    @Value("${file-upload}")
    String uploadPath;

    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping()
    public ResponseEntity<Page<UserInfo>> showAllUser(@PageableDefault(value = 5) Pageable pageable){
        Page<UserInfo> appUsers = this.userInfoService.findAll(pageable);
        if (appUsers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appUsers,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfo> findById(@PathVariable Long userId){
        Optional<UserInfo> userInfo = this.userInfoService.findByUserId(userId);
        if (!userInfo.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userInfo.get(), HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<UserInfo> findByName(@PathVariable String fullName) {
        Optional<UserInfo> userInfo = this.userInfoService.findUserInfoByFullName(fullName);
        if (!userInfo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userInfo.get(), HttpStatus.OK);
    }

    @PostMapping ("/avt/{userId}")
    public ResponseEntity<UserInfo> editAvt(@PathVariable Long userId, @ModelAttribute AvatarForm avatarForm) {
        Optional<UserInfo> userInfo = userInfoService.findByUserId(userId);
        if (!userInfo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MultipartFile multipartFile = avatarForm.getAvatar();
        String image;
        if (multipartFile.getSize() == 0) {
            image = userInfo.get().getAvatar();
        } else {
            String fileName = multipartFile.getOriginalFilename();
            long crt = System.currentTimeMillis();
            fileName =crt+fileName;
            image = fileName;
            try {
                FileCopyUtils.copy(avatarForm.getAvatar().getBytes(), new File(uploadPath + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UserInfo userInfo1 = new UserInfo(userInfo.get().getId(), userInfo.get().getEmail(), userInfo.get().getFullName(), userInfo.get().getPhoneNumber(), userInfo.get().getDateOfBirth(),userInfo.get().getAddress(),image, userInfo.get().getBackGround(), userInfo.get().getAppUser());
        return new ResponseEntity<>(userInfoService.save(userInfo1), HttpStatus.OK);
    }


    @PostMapping ("/bgr/{userId}")
    public ResponseEntity<UserInfo> editBgr(@PathVariable Long userId, @ModelAttribute BackgroundForm backgroundForm) {
        Optional<UserInfo> userInfo = userInfoService.findByUserId(userId);
        if (!userInfo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MultipartFile multipartFile = backgroundForm.getBackground();
        String image;
        if (multipartFile.getSize() == 0) {
            image = userInfo.get().getAvatar();
        } else {
            String fileName = multipartFile.getOriginalFilename();
            long crt = System.currentTimeMillis();
            fileName =fileName + crt;
            image = fileName;
            try {
                FileCopyUtils.copy(backgroundForm.getBackground().getBytes(), new File(uploadPath + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UserInfo userInfo1 = new UserInfo(userInfo.get().getId(), userInfo.get().getEmail(), userInfo.get().getFullName(), userInfo.get().getPhoneNumber(), userInfo.get().getDateOfBirth(),userInfo.get().getAddress(),userInfo.get().getAvatar(), image, userInfo.get().getAppUser());
        return new ResponseEntity<>(userInfoService.save(userInfo1), HttpStatus.OK);
    }

}
