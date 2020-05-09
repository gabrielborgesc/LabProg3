package com.bernardo.chat.services;

import com.bernardo.chat.domain.Message;
import com.bernardo.chat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void save(Message message) {
        this.messageRepository.save(message);
    }

    public List<Message> findAllByRoomIdOrderByCreatedDate(Integer roomId) {
        return this.messageRepository.findAllByRoomIdOrderByCreatedDate(roomId);
    }
}
