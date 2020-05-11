package com.bernardo.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardo.chat.beans.SessionBean;
import com.bernardo.chat.dto.ChatInfoCommand;

@Service
public class ChatService {
	private SessionBean sessionBean;
	
	@Autowired
	public ChatService(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	public ChatInfoCommand getChatInfo() {
		ChatInfoCommand chatInfo = new ChatInfoCommand( sessionBean.getCurrentUser().getId(), 
														sessionBean.getCurrentRoom().getId(), 
														sessionBean.getUsername(), 
														sessionBean.getCurrentRoom().getName());
		return chatInfo;
	}
}
