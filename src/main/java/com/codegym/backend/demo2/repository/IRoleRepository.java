package com.codegym.backend.demo2.repository;



import com.codegym.backend.demo2.model.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IRoleRepository extends JpaRepository<AppRole, Long> {
}
