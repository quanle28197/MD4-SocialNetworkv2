package com.codegym.backend.demo2.repository;

import com.codegym.backend.demo2.model.entity.NotificationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificationFriendRepository extends JpaRepository<NotificationUser,Long> {
    @Query(value = "select * from notification_user where to_user_id = ?1", nativeQuery = true)
    List<NotificationUser> showALl(Long id);
}
