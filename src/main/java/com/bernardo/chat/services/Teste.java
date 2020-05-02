package com.bernardo.chat.services;


import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.chat.beans.SessionBean;
import com.bernardo.chat.domain.Type;
import com.bernardo.chat.domain.User;
import com.bernardo.chat.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;


@RestController
public class Teste {
	@Autowired
	static
	UserRepository userRepository;
	
	@Autowired
	SessionBean sessionBean;
	
	
	
	public static void main(String[] args) {
		
		User user1 = new User("gabriel", "1234", "email", Type.admin);
		User user2 = new User("adriano", "1234", "email", Type.user);
		User user3 = new User("borges", "1234", "email", Type.admin);
		
		List<User> list = new List<User>();
		
		list.sort(Comparator.comparing(User::getUsername()));
		
	}
	
}
