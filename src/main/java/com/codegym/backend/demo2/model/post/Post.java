package com.codegym.backend.demo2.model.post;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String content ;
    private String imagePost ;
    private LocalDateTime dateCreated;
    private String status;

    public Post() {
    }

    public Post(Long id, String content, String imagePost, LocalDateTime dateCreated, String status) {
        this.id = id;
        this.content = content;
        this.imagePost = imagePost;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public Post(String content, String imagePost, LocalDateTime dateCreated, String status) {
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

    public String getImagePost() {
        return imagePost;
    }

    public void setImagePost(String imagePost) {
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
