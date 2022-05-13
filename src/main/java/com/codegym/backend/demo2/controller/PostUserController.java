package com.codegym.backend.demo2.controller;

import com.codegym.backend.demo2.service.comment.ICommentService;
import com.codegym.backend.demo2.service.post_user.IPostUserService;
import com.codegym.backend.demo2.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post_user")
@CrossOrigin("*")
public class PostUserController {

//    @Value("${file-upload}")
//    private String uploadPath;
//
//    @Autowired
//    private IPostUserService postUserService;
//
//    @Autowired
//    private ICommentService commentPostUserService;
//
//    @Autowired
//    private ILikePostUserService likePostUserService;
//
//    @Autowired
//    private ILikeCmtPostUserService likeCmtPostUserService;
//
//
//    @Autowired
//    private IImageUserService iImageUserService;
//
//    @Autowired
//    private IUserInfoService userInfoService;
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<PostUserFrontEnd>> showAllPostUser(@PathVariable Long userId) {
//        UserInfo userInfo = userInfoService.findByUserId(userId).get();
//        List<PostUser> postUsers = postUserService.showAllPostUserByUserInfoId(userInfo.getId());
//        List<PostUserFrontEnd> postUserFrontEnds  = new ArrayList<>();
//        for (int  i = 0 ; i< postUsers.size(); i++) {
//            postUserFrontEnds.add(new PostUserFrontEnd(postUsers.get(i).getId(),
//                    postUsers.get(i).getContent(),
//                    postUsers.get(i).getDateCreater(),
//                    iImageUserService.listImage(postUsers.get(i).getId()),
//                    postUsers.get(i).getStatus(),
//                    userInfo,
//                    likePostUserService.totalLikeByPost(postUsers.get(i).getId()).size(),
//                    commentPostUserService.showAllByPost(postUsers.get(i).getId()),
//                    commentPostUserService.showAllByPost(postUsers.get(i).getId()).size(),
//                    likeCmtPostUserService.listLikeComments(postUsers.get(i).getId()).size()
//                    ));
//        }
//        return new ResponseEntity<>(postUserFrontEnds, HttpStatus.OK);
//    }
//
//    @PostMapping("/{userId}")
//    public ResponseEntity<PostUser> createNewPost(@ModelAttribute PostUserForm postUserForm, @PathVariable Long userId) {
//        MultipartFile[] multipartFiles = postUserForm.getImage();
//        Optional<UserInfo> userInfo = userInfoService.findByUserId(userId);
//        List<String> images = new ArrayList<>();
//
//        PostUser postUser = new PostUser(
//                postUserForm.getContent(),
//                new Date(),
//                postUserForm.getStatus(),
//                userInfo.get()
//        );
//        postUserService.save(postUser);
//        if (multipartFiles.length != 0) {
//            for (int  i = 0 ; i < multipartFiles.length; i++) {
//                images.add(multipartFiles[i].getOriginalFilename());
//            }
//        }
//        for (int i = 0; i <images.size(); i++) {
//            iImageUserService.save(new ImagePostUser(images.get(i), postUser));
//            try {
//                FileCopyUtils.copy(multipartFiles[i].getBytes(), new File(uploadPath + images.get(i)));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return new ResponseEntity<>(postUser , HttpStatus.OK);
//    }

}
