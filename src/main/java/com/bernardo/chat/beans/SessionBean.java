package com.bernardo.chat.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.bernardo.chat.domain.User;

@Component
@SessionScope
public class SessionBean 
{
	private User sessionUser;
	
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
	
}
