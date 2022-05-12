package com.codegym.backend.demo2.controller;

import com.codegym.backend.demo2.model.entity.Group;
import com.codegym.backend.demo2.service.group.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @GetMapping()
    public ResponseEntity<Page<Group>> showAllGroup(Pageable pageable){
        Page<Group> groupPage = groupService.findAll(pageable);
        if (groupPage.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(groupPage,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> findById(@PathVariable Long id){
        Optional<Group> group = groupService.findById(id);
        if (!group.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(group.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Group> createNewGroup(@RequestBody Group group){
        return new ResponseEntity<>(groupService.save(group),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group> deleteById(@PathVariable Long id){
        Optional<Group> group = groupService.findById(id);
        if (!group.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        groupService.deleteById(id);
        return new ResponseEntity<>(group.get(),HttpStatus.GONE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> edit(@PathVariable Long id, @RequestBody Group group){
        Optional<Group> editGroup = groupService.findById(id);
        if (!editGroup.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        group.setId(id);
        return new ResponseEntity<>(groupService.save(group),HttpStatus.OK);
    }

}
