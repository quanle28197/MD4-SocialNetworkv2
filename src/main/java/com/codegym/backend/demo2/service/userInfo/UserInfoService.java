package com.codegym.backend.demo2.service.userInfo;


import com.codegym.backend.demo2.model.entity.UserInfo;
import com.codegym.backend.demo2.repository.IUserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements IUserInfoService{
    @Autowired
    private IUserInfoRepository userInfoRepository;

    @Override
    public Page<UserInfo> findAll(Pageable pageable) {
        return userInfoRepository.findAll(pageable);
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return userInfoRepository.findById(id);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Long findUserId(String email, String phoneNumber) {
        return null;
    }

    @Override
    public Optional<UserInfo> findByUserId(Long userId) {
        return Optional.empty();
    }

    @Override
    public Page<UserInfo> findUserInfoByFullName(String fullName , Pageable pageable) {
      return  userInfoRepository.findUserInfoByFullName(fullName , pageable);
    }
}
