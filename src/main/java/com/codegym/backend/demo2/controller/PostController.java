package com.codegym.backend.demo2.controller;

import com.codegym.backend.demo2.model.entity.Post;
import com.codegym.backend.demo2.service.post.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;
    @Autowired
    private Environment env;

    @GetMapping
    public ResponseEntity<Iterable<Post>> listPost() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }
}
