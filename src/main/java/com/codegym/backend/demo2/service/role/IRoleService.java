package com.codegym.backend.demo2.service.role;


import com.codegym.backend.demo2.service.IGeneralService;

import javax.management.relation.Role;


public interface IRoleService extends IGeneralService<Role> {
    Iterable<Role> findAll();
}
