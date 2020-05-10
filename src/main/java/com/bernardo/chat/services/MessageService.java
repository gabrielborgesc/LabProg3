package com.bernardo.chat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.bernardo.chat.domain.Message;
import com.bernardo.chat.dto.MessageCommand;
import com.bernardo.chat.repositories.MessageRepository;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public MessageService(MessageRepository messageRepository,
    					  SimpMessagingTemplate simpMessagingTemplate) {
        this.messageRepository = messageRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void save(Message message) {
        this.messageRepository.save(message);
    }

    public List<Message> findAllByRoomIdOrderByCreatedDate(Integer roomId) {
        return this.messageRepository.findAllByRoomIdOrderByCreatedDate(roomId);
    }
    
    public void receiveMessage(MessageCommand message) {
    	
    	System.out.println(message.getContent());
    	this.simpMessagingTemplate.convertAndSend("/topic/message", message);
    }
}
