package com.codegym.backend.demo2.service.message;

import com.codegym.backend.demo2.model.entity.Message;
import com.codegym.backend.demo2.repository.IMessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService implements IMessageService{
    private IMessageRepository messageRepository;

    @Override
    public Page<Message> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }


}
