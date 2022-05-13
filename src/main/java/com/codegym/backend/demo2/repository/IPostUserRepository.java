package com.codegym.backend.demo2.repository;

import com.codegym.backend.demo2.model.entity.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IPostUserRepository extends JpaRepository<PostUser, Long> {
    @Modifying
    @Query(value = "call deletePost(?1)", nativeQuery = true)
    void deletePost(Long id);

    @Query(value = "select * from post_user where user_info_id = ?1 order by id desc", nativeQuery = true)
    List<PostUser> showAllPostUserByUserInfoId(Long userInfoId);

}
