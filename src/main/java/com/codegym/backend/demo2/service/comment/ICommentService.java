package com.codegym.backend.demo2.service.comment;

import com.codegym.backend.demo2.model.entity.Comment;
import com.codegym.backend.demo2.service.IGeneralService;

public interface ICommentService extends IGeneralService<Comment> {
    Iterable<Comment> findAll();
}
