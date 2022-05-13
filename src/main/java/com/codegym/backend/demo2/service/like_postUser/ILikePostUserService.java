package com.codegym.backend.demo2.service.like_postUser;

import com.codegym.backend.demo2.model.entity.LikePostUser;
import com.codegym.backend.demo2.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface ILikePostUserService extends IGeneralService<LikePostUser> {
    Optional<LikePostUser> findLikePostUserByUserInfoIdAndPostUserId(Long userInfoId, Long postUserId);
    List<LikePostUser> totalLikeByPost(Long postUserId);
}
