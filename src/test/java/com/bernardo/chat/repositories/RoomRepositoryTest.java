package com.bernardo.chat.repositories;

import com.bernardo.chat.domain.Room;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest {
  private RoomRepository roomRepository;

  @Autowired
  public RoomRepositoryTest(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  // @Test
  public void findAllTest() {
    Iterable<Room> rooms = roomRepository.findAll();
    for (Room room : rooms) {
      System.out.println(room.getRoomName());
    }
  }

  // @Test
  public void findById() {
    Optional<Room> optional = roomRepository.findById(100);

    if (optional.isPresent()) {
      Room room = optional.get();

      System.out.println(room.getRoomName());
    } else {
      System.out.println("Null");
      System.out.println();
    }
  }

  // @Test
  public void findByRoomName() {
    Room room = roomRepository.findByRoomName("chat1");
    System.out.print(room.getId());
    System.out.println();
  }

  // @Test
  public void insert(Room newroom) {

    Room room = roomRepository.findByRoomName(newroom.getRoomName());
    if (room == null) {
      roomRepository.save(newroom);
    }
  }

  // @Test
  public void delete(String roomname) {
    Room room = roomRepository.findByRoomName(roomname);
    if (room != null) {
      roomRepository.deleteById(room.getId());
    }
  }

  @Test
  public void test() {

    Room room = new Room();
    room.setRoomName("chat2");
    // insert(room);
    delete("chat2");
  }
}
