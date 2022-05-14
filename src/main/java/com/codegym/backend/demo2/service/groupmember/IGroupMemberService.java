package com.codegym.backend.demo2.service.groupmember;

import com.codegym.backend.demo2.model.entity.Group1;
import com.codegym.backend.demo2.model.entity.GroupMember;
import com.codegym.backend.demo2.repository.IGroupMemberRepository;
import com.codegym.backend.demo2.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGroupMemberService extends IGeneralService<GroupMember> {

    Page<GroupMember> findAllByGroup1Id(Long group1Id, Pageable pageable);
}
