package com.codegym.backend.demo2.repository;

import com.codegym.backend.demo2.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends JpaRepository<Group,Long> {
}
