package com.codegym.backend.demo2.service.role;




import com.codegym.backend.demo2.model.entity.AppRole;
import com.codegym.backend.demo2.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Page<AppRole> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public AppRole save(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
    @Override
    public Iterable<AppRole> findAll() {
        return roleRepository.findAll();
    }
}
