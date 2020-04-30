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
	
	private String roomname;
	
	//
	// Métodos de acesso
	//
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomname() {
		return roomname;
	}
	
	public void serRoomname(String roomname) {
		this.roomname = roomname;
	}
	
}
