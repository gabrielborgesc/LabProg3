package com.bernardo.chat.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.chat.beans.SessionBean;
import com.bernardo.chat.domain.Room;
import com.bernardo.chat.domain.User;
import com.bernardo.chat.domain.Message;
import com.bernardo.chat.repositories.MessageRepository;
import com.bernardo.chat.repositories.RoomRepository;
import com.bernardo.chat.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;


public class RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	public void insert(Room newroom) {
		
		Room room = roomRepository.findByRoomName(newroom.getRoomName());
		if(room==null) {
			roomRepository.save(newroom);
	}
	}
	
	public void delete(String roomname) {
		Room room = roomRepository.findByRoomName(roomname);
		if(room!=null) {
			roomRepository.deleteById(room.getId());
		}
	}
	
	public List<Message> getMessages(Integer roomId) {
		List<Message> messages = messageRepository.findAllByRoomId(roomId);
		messages.get(0).sortMessages(messages);
		return messages;
		
	}
	
}
