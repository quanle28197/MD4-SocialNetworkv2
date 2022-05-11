package com.codegym.backend.demo2.repository.post;

import com.codegym.backend.demo2.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post,Long> {

}
