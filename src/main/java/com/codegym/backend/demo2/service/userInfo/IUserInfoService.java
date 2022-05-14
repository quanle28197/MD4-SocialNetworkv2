package com.codegym.backend.demo2.service.userInfo;




import com.codegym.backend.demo2.model.entity.UserInfo;
import com.codegym.backend.demo2.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface IUserInfoService extends IGeneralService<UserInfo> {
    Long findUserId(String email, String phoneNumber);

    Optional<UserInfo> findByUserId(Long appUserId);

    Optional<UserInfo>findUserInfoByFullName(String userInfo);
}
