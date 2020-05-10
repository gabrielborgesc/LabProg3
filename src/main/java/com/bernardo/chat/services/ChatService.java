package com.bernardo.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardo.chat.beans.SessionBean;

@Service
public class ChatService {
	private SessionBean sessionBean;
	
	@Autowired
	public ChatService(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
}
