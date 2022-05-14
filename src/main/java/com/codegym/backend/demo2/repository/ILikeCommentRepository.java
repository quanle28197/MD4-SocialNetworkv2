package com.codegym.backend.demo2.repository;

import com.codegym.backend.demo2.model.entity.LikeCommentPostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILikeCommentRepository extends JpaRepository<LikeCommentPostUser, Long> {
    @Query(value = "select * from like_comment_post_user where comment_post_user_id = ?1 and user_info_id = ?2",nativeQuery = true)
    Optional<LikeCommentPostUser> findLikeCommentByUser(Long cmPostUserId, Long fromUserId);

    @Query(value = "select * from like_comment_post_user where comment_post_user_id = ?1", nativeQuery = true)
    List<LikeCommentPostUser> listLikeComments(Long cmPostUserId);
}
