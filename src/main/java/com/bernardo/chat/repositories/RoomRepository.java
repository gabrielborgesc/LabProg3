package com.bernardo.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardo.chat.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>
{
	public Room findByRoomname(String rooomname);
}
