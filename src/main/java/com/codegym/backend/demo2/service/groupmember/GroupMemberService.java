package com.codegym.backend.demo2.service.groupmember;

import com.codegym.backend.demo2.model.entity.Group1;
import com.codegym.backend.demo2.model.entity.GroupMember;
import com.codegym.backend.demo2.repository.IGroupMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupMemberService implements IGroupMemberService {
    @Autowired
    private IGroupMemberRepository groupMemberRepository;

    @Override
    public Page<GroupMember> findAll(Pageable pageable) {
        return groupMemberRepository.findAll(pageable);
    }

    @Override
    public Optional<GroupMember> findById(Long id) {
        return groupMemberRepository.findById(id);
    }

    @Override
    public GroupMember save(GroupMember groupMember) {
        return groupMemberRepository.save(groupMember);
    }

    @Override
    public void deleteById(Long id) {
        groupMemberRepository.deleteById(id);
    }

    @Override
    public Page<GroupMember> findAllByGroup1Id(Long group1Id ,Pageable pageable) {
        return groupMemberRepository.findAllByGroup1Id(group1Id , pageable);
    }
}
