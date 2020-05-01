package com.bernardo.chat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardo.chat.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>
{
	public List<Message> findAllByRoomId(Integer roomId);///busca por todas as mensagens da sala
	///deveríamos restingir por data
	
	public List<Message> findAllByUserId(Integer userId);
	
	public List<Message> findAllByUserIdAndRoomId(Integer userId, Integer roomId);
	
	
}