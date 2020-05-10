package com.bernardo.chat.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.bernardo.chat.domain.Room;
import com.bernardo.chat.domain.Type;
import com.bernardo.chat.domain.User;

@Component
@SessionScope
public class SessionBean 
{
	private User sessionUser;
	
	private Room currentRoom;
	
	public void login(User user)
	{
		this.sessionUser = user;
	}
	
	public void logout()
	{
		this.sessionUser = null;
	}
	
	public boolean isLogged()
	{
		return sessionUser != null;
	}
	
	public String getUsername()
	{
		return sessionUser == null ? null : sessionUser.getUsername();
	}
	
	public Type getLoggedRole()
	{
		if(sessionUser == null)
			return null;
		return sessionUser.getType();
	}
	
	public void enterRoom(Room room) {
		this.currentRoom = room;
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
}
