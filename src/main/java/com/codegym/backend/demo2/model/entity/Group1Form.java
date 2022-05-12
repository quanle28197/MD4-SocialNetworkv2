package com.codegym.backend.demo2.model.entity;

import org.springframework.web.multipart.MultipartFile;

public class Group1Form {
    private Long id;

    private String groupName1;
    private MultipartFile backGroundUrl;

    public Group1Form() {
    }

    public Group1Form(Long id, String groupName1, MultipartFile backGroundUrl) {
        this.id = id;
        this.groupName1 = groupName1;
        this.backGroundUrl = backGroundUrl;
    }

    public Group1Form(String groupName1, MultipartFile backGroundUrl) {
        this.groupName1 = groupName1;
        this.backGroundUrl = backGroundUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName1() {
        return groupName1;
    }

    public void setGroupName1(String groupName1) {
        this.groupName1 = groupName1;
    }

    public MultipartFile getBackGroundUrl() {
        return backGroundUrl;
    }

    public void setBackGroundUrl(MultipartFile backGroundUrl) {
        this.backGroundUrl = backGroundUrl;
    }
}
