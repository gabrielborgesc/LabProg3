package com.bernardo.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.chat.services.ChatService;

@RestController
public class ChatController {
	
	private ChatService chatService;
	
	@Autowired
	public ChatController(ChatService chatService) 	{
		this.chatService = chatService;
	}

}
