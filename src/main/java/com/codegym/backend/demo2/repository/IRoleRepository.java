package com.codegym.backend.demo2.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
