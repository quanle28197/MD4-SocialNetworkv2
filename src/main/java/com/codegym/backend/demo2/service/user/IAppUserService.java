package com.codegym.backend.demo2.service.user;



import com.codegym.backend.demo2.model.entity.AppUser;
import com.codegym.backend.demo2.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGeneralService<AppUser>, UserDetailsService {
    AppUser findByUsername(String username);

    Iterable<AppUser> findAll();

    AppUser saveAdmin(AppUser appUser);

}
