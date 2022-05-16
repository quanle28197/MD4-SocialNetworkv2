package com.codegym.backend.demo2.controller;

import com.codegym.backend.demo2.model.entity.Message;
import com.codegym.backend.demo2.service.message.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @GetMapping()
    public ResponseEntity<Iterable<Message>> showAll(){
        Iterable<Message> messageList = messageService.findAllMessage();
        List<Message> messages = (List<Message>) messageList;
        if (messages.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(messages,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> findById(@PathVariable Long id){
        Optional<Message> message = messageService.findById(id);
        if (!message.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(message.get(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Message> createNewMessage(@RequestBody Message message){
        return new ResponseEntity<>(messageService.save(message),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteById(@PathVariable Long id){
        Optional<Message> message = messageService.findById(id);
        if (!message.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        messageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> edit(@PathVariable Long id, @RequestBody Message message){
        Optional<Message> message1 = messageService.findById(id);
        if (!message1.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        message.setId(id);
        return new ResponseEntity<>(messageService.save(message),HttpStatus.OK);
    }

}
