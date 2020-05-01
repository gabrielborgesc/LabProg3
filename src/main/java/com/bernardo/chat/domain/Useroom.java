package com.bernardo.chat.domain;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useroom", schema = "public")
public class Useroom 
{
	@Id
	private Integer user_id;
	
	private Integer room_id;
	
	//
	// Métodos de acesso
	//
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
