package com.codegym.backend.service.user;


import com.codegym.backend.model.User;
import com.codegym.backend.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String userName);

    Iterable<User> findAll();

    User saveAdmin(User user);
}
