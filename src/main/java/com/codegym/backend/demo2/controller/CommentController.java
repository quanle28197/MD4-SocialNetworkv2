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
import java.util.Optional;

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

    @PostMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @ModelAttribute CommentForm commentForm) {
        Optional<Comment> commentOptional = commentService.findById(id);
        commentForm.setId(commentOptional.get().getId());
        MultipartFile multipartFile = commentForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = environment.getProperty("file-upload");
        Comment existComment = new Comment(commentForm.getId(), commentForm.getContent(), fileName,
                commentForm.getUserInfo());
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (existComment.getImage().equals("fileName.jpg")) {
            existComment.setImage(commentOptional.get().getImage());
        }
        commentService.save(existComment);
        return new ResponseEntity<>(existComment, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteBook(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
