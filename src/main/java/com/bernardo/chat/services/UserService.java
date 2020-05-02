package com.bernardo.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.chat.beans.SessionBean;
import com.bernardo.chat.domain.User;
import com.bernardo.chat.domain.Message;
import com.bernardo.chat.domain.Room;
import com.bernardo.chat.repositories.MessageRepository;
import com.bernardo.chat.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	public void insert(User newuser) {
		
		User user = userRepository.findByUsername(newuser.getUsername());
		if(user==null) {
			userRepository.save(newuser);
	}
	}
	
	public void delete(String username) {
		User user = userRepository.findByUsername(username);
		if(user!=null) {
			userRepository.deleteById(user.getId());
		}
	}
	
	public void updateEmail(String username, String newEmail) {
		User user = userRepository.findByUsername(username);
		if(user!=null) {
			user.setEmail(newEmail);
			userRepository.save(user);
			
		}
	}
	
	public void updatePassword(String username, String newPassword) {
		User user = userRepository.findByUsername(username);
		if(user!=null) {
			user.setPassword(newPassword);
			userRepository.save(user);
			
		}
	}
	
	public void sendMessage(User user, Room room, Message message) {
		message.setDateSent();
		message.setUserId(user.getId());
		message.setRoomId(room.getId());
		
		messageRepository.save(message);
	}
}
