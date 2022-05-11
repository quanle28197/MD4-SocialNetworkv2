package com.codegym.backend.demo2.repository;



import com.codegym.backend.demo2.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
