package com.codegym.backend.demo2.service.like_cmtPostUser;

import com.codegym.backend.demo2.model.entity.LikeCommentPostUser;
import com.codegym.backend.demo2.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface ILikeCmtPostUserService extends IGeneralService<LikeCommentPostUser> {
    Optional<LikeCommentPostUser> findLikeCommentByUser(Long cmPostUserId, Long fromUserId);
    List<LikeCommentPostUser> listLikeComments(Long cmPostUserId);

}
