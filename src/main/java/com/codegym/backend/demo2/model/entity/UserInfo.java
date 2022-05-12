package com.codegym.backend.demo2.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String fullName;

    private String phoneNumber;

    private String dateOfBirth;

    private String address;

    private String avatar;

    private String backGround;

    @OneToOne
    private AppUser appUser;

    public UserInfo(String email, String fullName, String phoneNumber, String dateOfBirth, String address, String avatar, String backGround, AppUser appUser) {
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.avatar = avatar;
        this.backGround = backGround;
        this.appUser = appUser;
    }
}
