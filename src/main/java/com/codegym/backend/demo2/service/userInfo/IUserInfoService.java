package com.codegym.backend.service.userInfo;


import com.codegym.backend.model.entity.UserInfo;
import com.codegym.backend.service.IGeneralService;

import java.util.Optional;

public interface IUserInfoService extends IGeneralService<UserInfo> {
    Long findUserId(String email, String phoneNumber);

    Optional<UserInfo> findByUserId(Long userId);
}
