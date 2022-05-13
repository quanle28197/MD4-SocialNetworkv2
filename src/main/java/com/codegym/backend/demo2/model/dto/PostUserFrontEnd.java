package com.codegym.backend.demo2.model.dto;
import com.codegym.backend.demo2.model.entity.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserFrontEnd {
    private Long id;

    private String content;

    private Date dateCreater;

    private ImagePostUser[] image;

    @ManyToOne
    private StatusPostUser statusPostUser;

    private UserInfo userInfo;

    private Integer totalLike;

    private List<Comment> commentPostUsers;

    private Integer totalComment;

    private Integer totalLikeComment;

    public PostUserFrontEnd(String content, Date dateCreater, ImagePostUser[] image, StatusPostUser statusPostUser, UserInfo userInfo, Integer totalLike, List<Comment> commentPostUsers, Integer totalComment, Integer totalLikeComment) {
        this.content = content;
        this.dateCreater = dateCreater;
        this.image = image;
        this.statusPostUser = statusPostUser;
        this.userInfo = userInfo;
        this.totalLike = totalLike;
        this.commentPostUsers = commentPostUsers;
        this.totalComment = totalComment;
        this.totalLikeComment = totalLikeComment;
    }
}