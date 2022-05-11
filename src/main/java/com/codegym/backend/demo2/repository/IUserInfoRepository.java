package com.codegym.backend.demo2.repository;


import com.codegym.backend.demo2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserInfoRepository extends JpaRepository<User, Long> {

}
