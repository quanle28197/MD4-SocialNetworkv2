package com.codegym.backend.demo2.repository;

import com.codegym.backend.demo2.model.entity.FriendShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IFriendShipRepo extends JpaRepository<FriendShip, Long> {
    @Modifying
    @Query(value = "select to_user_info_id from friend_ship where from_user_info_id = ?1 and status = ?2", nativeQuery = true)
    List<Long> showListFriend(Long userId, Long statusId);

    @Modifying
    @Query(value = "delete from friend_ship where to_user_info_id = ?1 and from_user_info_id = ?2", nativeQuery = true)
    void deleteFriend(Long userInfoId1, Long userInfoId2);
}
