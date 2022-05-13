package com.codegym.backend.demo2.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groupmembers")
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group1 group1;
    @ManyToOne
    @JoinColumn(name = "userinfo_id")
    private UserInfo userInfo;

    public GroupMember() {
    }

    public GroupMember(Long id, Boolean status, Group1 group1, UserInfo userInfo) {
        this.id = id;
        this.status = status;
        this.group1 = group1;
        this.userInfo = userInfo;
    }

    public GroupMember(Boolean status, Group1 group1, UserInfo userInfo) {
        this.status = status;
        this.group1 = group1;
        this.userInfo = userInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Group1 getGroup1() {
        return group1;
    }

    public void setGroup1(Group1 group1) {
        this.group1 = group1;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
