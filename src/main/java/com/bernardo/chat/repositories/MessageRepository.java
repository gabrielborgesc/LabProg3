package com.bernardo.chat.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardo.chat.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>
{
	public ArrayList<Message> findByRoomId(Integer room_id);///busca por todas as mensagens da sala
	///deveríamos restingir por data
}