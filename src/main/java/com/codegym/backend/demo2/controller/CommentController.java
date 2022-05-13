package com.codegym.backend.demo2.controller;

import com.codegym.backend.demo2.model.dto.CommentForm;
import com.codegym.backend.demo2.model.entity.Comment;
import com.codegym.backend.demo2.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    ICommentService commentService;
    @Autowired
    Environment environment;

    @GetMapping("")
    public ResponseEntity<Iterable<Comment>> listAllComment() {
        Iterable<Comment> comments = commentService.findAll();
        List<Comment> commentList = (List<Comment>) comments;
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Comment> writeComment(@ModelAttribute CommentForm commentForm) {
        MultipartFile multipartFile = commentForm.getImage();
        String fileUpload = environment.getProperty("file-upload");
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Comment comment = new Comment(commentForm.getContent(), fileName, commentForm.getUserInfo());
        commentService.save(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
