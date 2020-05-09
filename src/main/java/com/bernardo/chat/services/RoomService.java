package com.bernardo.chat.services;

import com.bernardo.chat.domain.Message;
import com.bernardo.chat.domain.Room;
import com.bernardo.chat.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

  private RoomRepository roomRepository;
  private MessageService messageService;

  @Autowired
  public RoomService(RoomRepository roomRepository, MessageService messageService) {
    this.roomRepository = roomRepository;
    this.messageService = messageService;
  }

  public void insert(Room newRoom) {

    Room room = this.findByName(newRoom.getName());
    if (room == null) {
      this.save(newRoom);
    }
  }

  public void deleteByName(String name) {
    Room room = this.findByName(name);
    if (room != null) {
      this.deleteById(room.getId());
    }
  }

  public List<Message> getMessages(Integer roomId) {
    return this.messageService.findAllByRoomIdOrderByCreatedDate(roomId);
  }

  private void deleteById(Integer id) {
    this.roomRepository.deleteById(id);
  }

  private Room findByName(String name) {
    return this.roomRepository.findByName(name);
  }

  private Room save(Room room) {
    return this.roomRepository.save(room);
  }
}
