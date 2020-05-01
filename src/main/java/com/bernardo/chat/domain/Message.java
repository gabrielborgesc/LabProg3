package com.bernardo.chat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "message", schema = "public")

public class Message {
	
	@Id
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
	
	public Date getDatesent() {
		return datesent;
	}
	
	public void setDateSent(Date date) {
		datesent = date;
		//datesent = new Date() dessa forma datesent receberia o valor da data do computador
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

	public void setDatesent(Date datesent) {
		this.datesent = datesent;
	}
	
	
	
	
	
}
