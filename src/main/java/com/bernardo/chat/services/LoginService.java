package com.bernardo.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.chat.domain.User;
import com.bernardo.chat.repositories.UserRepository;

@RestController
public class LoginService 
{
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public String doLogin(String username, String password)
	{
		User user = userRepository.findByUsername(username);
		
		if(password != null && password.equals(user.getPassword()))
		{
			return user.getId().toString();
		}
		
		return "failed";
	}
}
