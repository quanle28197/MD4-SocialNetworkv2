package com.codegym.backend.demo2.repository;

import com.codegym.backend.demo2.model.entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupMemberRepository extends JpaRepository<GroupMember,Long> {
}
