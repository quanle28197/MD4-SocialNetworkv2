package com.codegym.backend.demo2.service.user;


import com.codegym.backend.demo2.model.dto.loginForm.UserPrincipal;
import com.codegym.backend.demo2.model.entity.AppRole;
import com.codegym.backend.demo2.model.entity.AppUser;
import com.codegym.backend.demo2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<AppUser> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public AppUser save(AppUser user) {
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(password);//Mã hóa pass của người dùng
        user.setPassword(encodePassword);
        List<AppRole> roles = new ArrayList<>();
        roles.add(new AppRole(2L, "ROLE_USER"));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Iterable<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser saveAdmin(AppUser user) {
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(password);//Mã hóa pass của admin
        user.setPassword(encodePassword);
        List<AppRole> roles = new ArrayList<>();
        roles.add(new AppRole(1L, "ROLE_ADMIN"));
        user.setRoles(roles);
        return userRepository.save(user);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        return UserPrincipal.build(user);
    }
}
