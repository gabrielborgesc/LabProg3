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
	
	private Integer user_id;
	
	private Integer room_id;
	
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
		return user_id;
	}

	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRoomId() {
		return room_id;
	}

	public void setRoomId(Integer room_id) {
		this.room_id = room_id;
	}
	
	
	
}
