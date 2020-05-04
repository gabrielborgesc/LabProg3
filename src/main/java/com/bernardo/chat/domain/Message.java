package com.bernardo.chat.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class Message implements Comparable<Message> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String text;

	@CreatedDate
	private Date createdAt;

	@ManyToOne
	private User user;

	@ManyToOne
	private Room room;
	
	//
	// Métodos de acesso
	//
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public int compareTo(Message message) {
		return this.getCreatedAt().compareTo(message.getCreatedAt());
	}
	
	public List<Message> sortMessages(List<Message> messages){
		Collections.sort(messages);
		Collections.reverse(messages);
		return messages;
	}
	
}
