package com.codegym.backend.demo2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserInfo fromUserInfo;

    @ManyToOne
    private UserInfo toUserInfo;

    private int status;

    public FriendShip(UserInfo fromUserInfo, UserInfo toUserInfo, int status) {
        this.fromUserInfo = fromUserInfo;
        this.toUserInfo = toUserInfo;
        this.status = status;
    }
}
