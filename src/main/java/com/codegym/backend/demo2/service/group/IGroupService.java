package com.codegym.backend.demo2.service.group;

import com.codegym.backend.demo2.model.entity.Group1;
import com.codegym.backend.demo2.service.IGeneralService;

public interface IGroupService extends IGeneralService<Group1> {
    Iterable<Group1> findAllGroup();
}
