package com.codegym.backend.demo2.service.message;

import com.codegym.backend.demo2.model.entity.Message;
import com.codegym.backend.demo2.service.IGeneralService;

public interface IMessageService extends IGeneralService<Message> {
    Iterable<Message> findAllMessage();
}
