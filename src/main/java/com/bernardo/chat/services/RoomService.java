package com.bernardo.chat.services;

import com.bernardo.chat.domain.Message;
import com.bernardo.chat.domain.Room;
import com.bernardo.chat.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

  private RoomRepository roomRepository;
  private MessageService messageService;

  public RoomService(RoomRepository roomRepository, MessageService messageService) {
    this.roomRepository = roomRepository;
    this.messageService = messageService;
  }

  public void insert(Room newroom) {

    Room room = this.findByRoomName(newroom.getRoomName());
    if (room == null) {
      this.save(newroom);
    }
  }

  public void delete(String roomname) {
    Room room = this.findByRoomName(roomname);
    if (room != null) {
      this.deleteById(room.getId());
    }
  }

  public List<Message> getMessages(Integer roomId) {
    List<Message> messages = this.messageService.findAllByRoomId(roomId);
    messages.get(0).sortMessages(messages);
    return messages;
  }

  private void deleteById(Integer id) {
    this.roomRepository.deleteById(id);
  }

  private Room findByRoomName(String roomName) {
    return this.findByRoomName(roomName);
  }

  private Room save(Room room) {
    return this.roomRepository.save(room);
  }
}
