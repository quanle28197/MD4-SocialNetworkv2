package com.codegym.backend.demo2.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "userInfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private LocalDate dob;
    private String address;
    private String avatarUrl;
    private String account;

    public UserInfo() {
    }

    public UserInfo(Long id, String fullName, LocalDate dob, String address, String avatarUrl, String account) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.avatarUrl = avatarUrl;
        this.account = account;
    }

    public UserInfo(String fullName, LocalDate dob, String address, String avatarUrl, String account) {
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.avatarUrl = avatarUrl;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
