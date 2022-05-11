package com.codegym.backend.demo2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    private List<AppRole> roles;

    public AppUser(String username, String password, List<AppRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}