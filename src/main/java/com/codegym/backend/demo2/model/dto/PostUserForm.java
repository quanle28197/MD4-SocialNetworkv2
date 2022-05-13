package com.codegym.backend.demo2.model.dto;

import com.codegym.backend.demo2.model.entity.StatusPostUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserForm {
    private String content;

    private StatusPostUser status;

    private MultipartFile[] image;

    public PostUserForm(String content, StatusPostUser status) {
        this.content = content;
        this.status = status;
    }
}