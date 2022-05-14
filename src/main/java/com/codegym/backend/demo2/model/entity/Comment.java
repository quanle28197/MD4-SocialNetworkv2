package com.codegym.backend.demo2.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String image;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "post_user_id")
    private PostUser postUser;
    @ManyToOne
    @JoinColumn(name = "info_id")
    private UserInfo userInfo;

    public Comment() {
    }


    public Comment(String content, String image, UserInfo userInfo) {
        this.content = content;
        this.image = image;
        this.userInfo = userInfo;
    }

    public Comment(String content, String image, LocalDateTime dateTime, PostUser postUser, UserInfo userInfo) {
        this.content = content;
        this.image = image;
        this.dateTime = dateTime;
        this.postUser = postUser;
        this.userInfo = userInfo;
    }

    public Comment(Long id, String content, String image, LocalDateTime dateTime, PostUser postUser, UserInfo userInfo) {
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
