package com.bernardo.chat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageCommand 
{
	private String content;
	
	private Integer userId;
	
	private Integer roomId;
	
	public MessageCommand(@JsonProperty("content") String content,
						  @JsonProperty("userId") Integer userId,
						  @JsonProperty("roomId") Integer roomId)
	{
		this.content = content;
		this.userId = userId;
		this.roomId = roomId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
