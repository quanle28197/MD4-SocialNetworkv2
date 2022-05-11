package com.codegym.backend.demo2.service.role;


import com.codegym.backend.demo2.model.entity.Role;
import com.codegym.backend.demo2.service.IGeneralService;




public interface IRoleService extends IGeneralService<Role> {
    Iterable<Role> findAll();
}
