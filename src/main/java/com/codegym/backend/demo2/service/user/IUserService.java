package com.codegym.backend.demo2.service.user;



import com.codegym.backend.demo2.model.entity.User;
import com.codegym.backend.demo2.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String userName);

    Iterable<User> findAll();

    User saveAdmin(User user);
}
