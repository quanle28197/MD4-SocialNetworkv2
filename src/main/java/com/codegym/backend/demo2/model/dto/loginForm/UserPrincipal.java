package com.codegym.backend.demo2.model.dto.loginForm;


import com.codegym.backend.demo2.model.entity.AppRole;
import com.codegym.backend.demo2.model.entity.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private List<? extends GrantedAuthority> appRoles;

    public UserPrincipal(Long id, String username, String password, List<? extends GrantedAuthority> appRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.appRoles = appRoles;
    }

    public static UserPrincipal build(AppUser appUser) {
        //Lấy ra role của user
        List<AppRole> appRoles = appUser.getRoles();
        //tạo list quyền cho user principal
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (AppRole appRole: appRoles) {
            //thêm quyền vào list
            authorities.add(new SimpleGrantedAuthority(appRole.getName()));
        }
        return new UserPrincipal(
                appUser.getId(),
                appUser.getUsername(),
                appUser.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return appRoles;
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }
}
