package com.codegym.backend.demo2.service.image_postuser;

import com.codegym.backend.demo2.model.entity.ImagePostUser;
import com.codegym.backend.demo2.service.IGeneralService;

public interface IImageUserService extends IGeneralService<ImagePostUser> {
    ImagePostUser[] listImage(Long postUser);
}
