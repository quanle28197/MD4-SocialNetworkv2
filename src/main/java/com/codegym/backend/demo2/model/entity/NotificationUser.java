package com.codegym.backend.demo2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date dateCreated;



    @ManyToOne
    private UserInfo fromUser;
    @ManyToOne
    private UserInfo toUser;

    public NotificationUser(String content, Date dateCreated, UserInfo fromUser, UserInfo toUser) {
        this.content = content;
        this.dateCreated = dateCreated;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}
