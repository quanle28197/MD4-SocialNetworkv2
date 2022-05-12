package com.codegym.backend.demo2.controller;

import com.codegym.backend.demo2.model.entity.Group1;
import com.codegym.backend.demo2.service.group.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/group1")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @GetMapping()
    public ResponseEntity<Iterable<Group1>> showAllGroup(){
        Iterable<Group1> groupList = groupService.findAllGroup();
        List<Group1> group1List = (List<Group1>) groupList;
        if (group1List.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(group1List,HttpStatus.OK);

    }

//    @GetMapping()
//    public ResponseEntity<Page<Group1>> showAll(Pageable pageable){
//        Page<Group1> groupPage = groupService.findAll(pageable);
//        if (groupPage.isEmpty())
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(groupPage,HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Group1> findById(@PathVariable Long id){
        Optional<Group1> group = groupService.findById(id);
        if (!group.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(group.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Group1> createNewGroup(@RequestBody Group1 group1){
        return new ResponseEntity<>(groupService.save(group1),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group1> deleteById(@PathVariable Long id){
        Optional<Group1> group = groupService.findById(id);
        if (!group.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        groupService.deleteById(id);
        return new ResponseEntity<>(group.get(),HttpStatus.GONE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group1> edit(@PathVariable Long id, @RequestBody Group1 group1){
        Optional<Group1> editGroup = groupService.findById(id);
        if (!editGroup.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        group1.setId(id);
        return new ResponseEntity<>(groupService.save(group1),HttpStatus.OK);
    }

}
