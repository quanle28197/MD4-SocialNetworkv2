package com.codegym.backend.demo2.service.role;


import com.codegym.backend.demo2.model.entity.AppRole;
import com.codegym.backend.demo2.service.IGeneralService;

public interface IAppRoleService extends IGeneralService<AppRole> {
    Iterable<AppRole> findAll();
}
