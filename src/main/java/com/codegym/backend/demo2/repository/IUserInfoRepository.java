package com.codegym.backend.demo2.repository;



import com.codegym.backend.demo2.model.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query(value = "select user_id from  user_info where email = ?1 and phone_number = ?2",nativeQuery = true)
    Long findUserId(String email, String phone_number) ;

    @Query(value="select  * from user_info where user_id = ?1", nativeQuery = true)
    Optional<UserInfo> findByUserId(Long userId);
}
