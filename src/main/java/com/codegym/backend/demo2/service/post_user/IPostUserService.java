package com.codegym.backend.demo2.service.post_user;

import com.codegym.backend.demo2.model.entity.PostUser;
import com.codegym.backend.demo2.service.IGeneralService;

import java.util.List;

public interface IPostUserService extends IGeneralService<PostUser> {
    void deletePost(Long id);
    List<PostUser> showAllPostUserByUserInfoId(Long userInfoId);
    List<PostUser> findAll();
}
