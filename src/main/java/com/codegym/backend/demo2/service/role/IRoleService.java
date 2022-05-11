package com.codegym.backend.service.role;

import com.codegym.backend.model.entity.Role;
import com.codegym.backend.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Iterable<Role> findAll();
}
