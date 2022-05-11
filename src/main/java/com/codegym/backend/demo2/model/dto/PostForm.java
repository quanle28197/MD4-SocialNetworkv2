package com.codegym.backend.demo2.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class PostForm {
    private Long id ;
    private String content;
    private MultipartFile imagePost;
    private LocalDateTime dateCreated;
    private String status;

    public PostForm() {
    }

    public PostForm(Long id, String content, MultipartFile imagePost, LocalDateTime dateCreated, String status) {
        this.id = id;
        this.content = content;
        this.imagePost = imagePost;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public PostForm(String content, MultipartFile imagePost, LocalDateTime dateCreated, String status) {
        this.content = content;
        this.imagePost = imagePost;
        this.dateCreated = dateCreated;
        this.status = status;
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

    public MultipartFile getImagePost() {
        return imagePost;
    }

    public void setImagePost(MultipartFile imagePost) {
        this.imagePost = imagePost;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
