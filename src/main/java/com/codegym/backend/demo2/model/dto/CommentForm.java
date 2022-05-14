package com.codegym.backend.demo2.model.dto;

import com.codegym.backend.demo2.model.entity.PostUser;
import com.codegym.backend.demo2.model.entity.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class CommentForm {
    private Long id;
    private String content;
    private MultipartFile image;
    private LocalDateTime dateTime;
    private PostUser postUser;
    private UserInfo userInfo;

    public CommentForm() {
    }


    public CommentForm(String content, MultipartFile image, UserInfo userInfo) {
        this.content = content;
        this.image = image;
        this.userInfo = userInfo;
    }

    public CommentForm(Long id, String content, MultipartFile image, LocalDateTime dateTime, PostUser postUser, UserInfo userInfo) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.dateTime = dateTime;
        this.postUser = postUser;
        this.userInfo = userInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public PostUser getPostUser() {
        return postUser;
    }

    public void setPostUser(PostUser postUser) {
        this.postUser = postUser;
    }
}
