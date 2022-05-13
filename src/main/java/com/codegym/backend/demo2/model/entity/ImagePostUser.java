package com.codegym.backend.demo2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagePostUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @ManyToOne
    private Post postUser;

    public ImagePostUser(String image, Post postUser) {
        this.image = image;
        this.postUser = postUser;
    }
}
