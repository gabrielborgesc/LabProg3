package com.bernardo.chat.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bernardo.chat.domain.Message;
import com.bernardo.chat.domain.Room;
import com.bernardo.chat.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageRepositoryTest 
{
	@Autowired
	MessageRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	
	//@Test
	public void findAllTest()
	{
		List<Message> messages = repository.findAll();
		for (Message message : messages) {
			System.out.println(message.getText());
			System.out.println();
		}
		
	}
	
	public void insert(String text, Integer UserId, Integer RoomId) {
		
		Optional<User> optionalUser = userRepository.findById(UserId);
		
		Optional<Room> optionalRoom = roomRepository.findById(RoomId);
		
		
	if(optionalUser.isPresent() && optionalRoom.isPresent()) {
		
		Message message = new Message();
		message.setDateSent();
		message.setUserId(UserId);
		message.setRoomId(RoomId);
		message.setText(text);
		
		repository.save(message);
		
	}
	else {
		System.out.println("Usuario ou sala inexistentes");
		System.out.println();
	}
}
		
	
	@Test
	public void test() {
		
		List<Message> list = repository.findAllByRoomId(3);
		Message m = new Message();
		m.sortMessages(list);
		
		for(Message message:list) {
			System.out.println(message.getText()+"  "+ message.getDateSent());
			System.out.println();
		}
		}
		
	}
	
