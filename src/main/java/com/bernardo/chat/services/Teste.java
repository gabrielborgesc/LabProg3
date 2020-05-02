package com.bernardo.chat.services;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.chat.beans.SessionBean;
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
	
	
	
	public static void main(String[] args) throws NotFoundException {
		User user = userRepository.findByUsername("gabriel").
				orElseThrow(() -> new NotFoundException("User gabriel not found"));
		System.out.println(user.getUsername());
	}
	
}
