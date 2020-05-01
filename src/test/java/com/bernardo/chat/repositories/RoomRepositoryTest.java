package com.bernardo.chat.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.bernardo.chat.domain.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest 
{
	@Autowired
	RoomRepository repository;
	
	
	//@Test
	public void findAllTest()
	{
		List<Room> rooms = repository.findAll();
		for (Room room : rooms) {
			System.out.println(room.getRoomName());
		}
		
	}
	
	//@Test
	public void findById()
	{
		Optional<Room> optional = repository.findById(100);
		
		if(optional.isPresent()) {
		Room room = optional.get();
		
		System.out.println(room.getRoomName());
		}
		else {
			System.out.println("Null");
			System.out.println();
		}
	}
	
	//@Test
	public void findByRoomName()
	{
		Room room = repository.findByRoomName("chat1");
		System.out.print(room.getId());
		System.out.println();
	}
	
	
	//@Test
		public void insert(Room newroom) {
				
			Room room = repository.findByRoomName(newroom.getRoomName());
			if(room==null) {
			repository.save(newroom);
		}
		}
	
	//@Test
		public void delete(String roomname) {
			Room room = repository.findByRoomName(roomname);
			if(room!=null) {
			repository.deleteById(room.getId());
			}
		}
		
		
	
	@Test
	public void test() {
		
		Room room = new Room();
		room.setRoomName("chat2");
		//insert(room);
		delete("chat2");
		
		
	}
	
}
