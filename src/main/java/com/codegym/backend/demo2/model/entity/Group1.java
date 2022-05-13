package com.codegym.backend.demo2.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "group1")
public class Group1 {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName1;
    private String backGroundUrl;

    public Group1(Long id, String groupName1, String backGroundUrl) {
        this.id = id;
        this.groupName1 = groupName1;
        this.backGroundUrl = backGroundUrl;
    }

    public Group1(String groupName1, String backGroundUrl) {
        this.groupName1 = groupName1;
        this.backGroundUrl = backGroundUrl;
    }

    public Group1() {
    }

    public String getBackGroundUrl() {
        return backGroundUrl;
    }

    public void setBackGroundUrl(String backGroundUrl) {
        this.backGroundUrl = backGroundUrl;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return groupName1;
    }

    public void setName(String name) {
        this.groupName1 = name;
    }
}
