package com.bernardo.chat.services;

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
public class LoginService 
{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SessionBean sessionBean;
	
	@PostMapping("/login")
	public String doLogin(@RequestBody LoginRequest request)
	{
		User user = userRepository.findByUsername(request.getUsername());
		
		System.out.println(request.getUsername());
		System.out.println(request.getPassword());
		
		if(request.getPassword()!= null && request.getPassword().equals(user.getPassword()))
		{
			sessionBean.login(user);
			
			return "success";
		}
		
		return "failed";
	}
	
	@GetMapping("/login")
	public boolean logged()
	{
		return sessionBean.isLogged();
	}
}

class LoginRequest
{
	private String username;
	private String password;
	
	LoginRequest(@JsonProperty("username") String username,
			@JsonProperty("password") String password)
	{
		this.username = username;
		this.password = password;
	}
	
	LoginRequest() { }
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
