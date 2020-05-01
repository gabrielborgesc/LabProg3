package com.bernardo.chat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "message", schema = "public")

public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private Integer id;
	
	private String text;
	
	private Date datesent;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="room_id")
	private Integer roomId;
	
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
	
	public Date getDateSent() {
		return datesent;
	}
	
	public void setDateSent() {
		Date date = new Date(); //date recebe o valor da data do computador
		datesent = date;
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	
}
