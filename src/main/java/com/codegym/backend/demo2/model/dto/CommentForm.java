package com.codegym.backend.demo2.model.dto;

import com.codegym.backend.demo2.model.entity.UserInfo;
import org.springframework.web.multipart.MultipartFile;

public class CommentForm {
    private Long id;
    private String content;
    private MultipartFile image;
    private UserInfo userInfo;

    public CommentForm() {
    }

    public CommentForm(String content, UserInfo userInfo) {
        this.content = content;
        this.userInfo = userInfo;
    }

    public CommentForm(String content, MultipartFile image, UserInfo userInfo) {
        this.content = content;
        this.image = image;
        this.userInfo = userInfo;
    }

    public CommentForm(Long id, String content, MultipartFile image, UserInfo userInfo) {
        this.id = id;
        this.content = content;
        this.image = image;
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
}
