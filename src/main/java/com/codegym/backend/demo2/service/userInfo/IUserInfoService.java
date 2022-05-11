package com.codegym.backend.demo2.service.userInfo;




import com.codegym.backend.demo2.model.entity.UserInfo;
import com.codegym.backend.demo2.service.IGeneralService;

import java.util.Optional;

public interface IUserInfoService extends IGeneralService<UserInfo> {
    Long findUserId(String email, String phoneNumber);

    Optional<UserInfo> findByUserId(Long userId);
}
