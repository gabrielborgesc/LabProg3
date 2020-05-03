package com.bernardo.chat.services;

import com.bernardo.chat.domain.Message;
import com.bernardo.chat.repositories.MessageRepository;

public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void save(Message message) {
        this.messageRepository.save(message);
    }
}
