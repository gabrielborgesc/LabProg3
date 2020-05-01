package com.bernardo.chat.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room", schema = "public")
public class Room 
{
	@Id
	@Column(name = "room_id")
	private Integer id;
	
	@Column(name = "room_name")
	private String roomName;
	
	//
	// Métodos de acesso
	//
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
}
