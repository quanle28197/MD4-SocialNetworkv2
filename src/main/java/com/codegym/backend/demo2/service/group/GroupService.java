package com.codegym.backend.demo2.service.group;

import com.codegym.backend.demo2.model.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private IGroupService groupService;

    @Override
    public Page<Group> findAll(Pageable pageable) {
        return groupService.findAll(pageable);
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupService.findById(id);
    }

    @Override
    public Group save(Group group) {
        return groupService.save(group);
    }

    @Override
    public void deleteById(Long id) {
        groupService.deleteById(id);
    }
}
