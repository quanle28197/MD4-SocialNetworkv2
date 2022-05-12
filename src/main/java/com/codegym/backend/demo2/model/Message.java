package com.codegym.backend.demo2.model;

import javax.persistence.*;

@Entity
@Table (name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userInfo_id")
    private UserInfo userInfo;

    private String content;

    public Message() {
    }

    public Message(UserInfo userInfo, String content) {
        this.userInfo = userInfo;
        this.content = content;
    }

    public Message(Long id, UserInfo userInfo, String content) {
        this.id = id;
        this.userInfo = userInfo;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
