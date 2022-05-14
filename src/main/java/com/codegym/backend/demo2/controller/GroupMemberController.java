package com.codegym.backend.demo2.controller;

import com.codegym.backend.demo2.model.entity.GroupMember;
import com.codegym.backend.demo2.service.group.IGroupService;
import com.codegym.backend.demo2.service.groupmember.IGroupMemberService;
import com.codegym.backend.demo2.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/groupmember")
public class GroupMemberController {
    @Autowired
    private IGroupMemberService groupMemberService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IGroupService groupService;

    @GetMapping()
    public ResponseEntity<Page<GroupMember>> showAllGroupMembers(@PageableDefault(value = 5) Pageable pageable ) {
        Page<GroupMember> groupMembers = this.groupMemberService.findAll(pageable);
        if (groupMembers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(groupMembers, HttpStatus.OK);
    }
@GetMapping("/{groupId}")
public ResponseEntity<Page<GroupMember>> showAllGroupMembersByGroupId(@PageableDefault(value = 5)Pageable pageable, @PathVariable Long groupId){
        groupService.findById(groupId);
        Page<GroupMember> groupMembers = this.groupMemberService.findAllByGroup1Id(groupId,pageable);
    if (groupMembers.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(groupMembers, HttpStatus.OK);
}
    @PostMapping("")
    public ResponseEntity<GroupMember> createGroupMember(@RequestBody GroupMember groupMember) {
        return new ResponseEntity<>(groupMemberService.save(groupMember), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GroupMember> deleteGroupMember(@PathVariable Long id) {
        Optional<GroupMember> groupMember = groupMemberService.findById(id);
        if (groupMember.isPresent()) {
            groupMemberService.deleteById(id);
            return new ResponseEntity<>(groupMember.get(), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupMember> editGroupMember (@PathVariable Long id , @RequestBody GroupMember groupMember){
        Optional<GroupMember> groupMember1 = groupMemberService.findById(id);
        if (groupMember1.isPresent()){
            groupMember.setId(id);
            return new ResponseEntity<>(groupMemberService.save(groupMember),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
