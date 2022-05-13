package com.codegym.backend.demo2.controller;

import com.codegym.backend.demo2.model.entity.Group1;
import com.codegym.backend.demo2.model.entity.Group1Form;
import com.codegym.backend.demo2.service.group.IGroupService;
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
@RequestMapping("/group1")
public class GroupController {
    @Autowired
    private IGroupService groupService;
    @Autowired
    private Environment environment;

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
    public ResponseEntity<Group1> createNewGroup(@ModelAttribute Group1Form group1Form){
        MultipartFile backGroundUrl = group1Form.getBackGroundUrl();
        String fileName = backGroundUrl.getOriginalFilename();
        String fileUpload = environment.getProperty("file-upload");
        try{
            FileCopyUtils.copy(backGroundUrl.getBytes(),new File(fileUpload + fileName));
        }catch (IOException e) {
            e.printStackTrace();
        }
        Group1 group1 = new Group1(group1Form.getId(),group1Form.getGroupName1(),fileName);
        groupService.save(group1);
        return new ResponseEntity<>(group1,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group1> deleteById(@PathVariable Long id){
        Optional<Group1> group = groupService.findById(id);
        groupService.deleteById(id);
        return new ResponseEntity<>(group.get(),HttpStatus.GONE);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Group1> edit(@PathVariable Long id, @ModelAttribute Group1Form group1Form) {
        Optional<Group1> group1 = groupService.findById(id);
//        group1Form.setId(group1.get().getId());
        group1Form.setId(id);
        MultipartFile backGroundUrl = group1Form.getBackGroundUrl();
        String fileName = backGroundUrl.getOriginalFilename();
        String fileUpload = environment.getProperty("file-upload");
        try {
            FileCopyUtils.copy(backGroundUrl.getBytes(),new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Group1 newGroup1 = new Group1(id,group1Form.getGroupName1(),fileName);
        if (newGroup1.getBackGroundUrl().equals("blank.jpg"))
            newGroup1.setBackGroundUrl(group1.get().getBackGroundUrl());
        groupService.save(newGroup1);
        return new ResponseEntity<>(newGroup1,HttpStatus.OK);
    }


}
