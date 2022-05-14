package com.codegym.backend.demo2.repository;

import com.codegym.backend.demo2.model.entity.Group1;
import com.codegym.backend.demo2.model.entity.GroupMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGroupMemberRepository extends JpaRepository<GroupMember,Long> {
    @Query(  value = "SELECT * FROM groupmembers WHERE group_id=?1",nativeQuery = true)
    Page<GroupMember> findAllByGroup1Id(Long group1Id, Pageable pageable);
}
