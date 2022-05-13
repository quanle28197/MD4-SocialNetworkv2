package com.codegym.backend.demo2.service.group;

import com.codegym.backend.demo2.model.entity.Group1;
import com.codegym.backend.demo2.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private IGroupRepository groupRepository;

    @Override
    public Iterable<Group1> findAllGroup(){
        return groupRepository.findAll();
    }

    @Override
    public Page<Group1> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Override
    public Optional<Group1> findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group1 save(Group1 group1) {
        return groupRepository.save(group1);
    }

    @Override
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }
}
